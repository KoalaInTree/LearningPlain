package com.djcao.alogic;

import java.util.HashMap;

/**
 * 类型：自顶向下-归并排序
 * 时间复杂度：NlogN
 * 空间复杂度：N
 * 思想：分治、归并。把两个有序数组合并成一个有序数组。
 * @author djcao
 * @date 2020-05-03 22:40
 */
public class MergeSortStrategy extends AbstractSortStrategy implements SortStrategy {
    Comparable[] ax;

    @Override
    public void sort(Comparable[] a) {
        ax = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) /2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            ax[i] = a[i];
        }
        int m = lo;
        int n = mid +1;
        for (int i = lo; i <= hi; i++) {
            if (m > mid) a[i] = ax[n++];
            else if (n > hi) a[i] = ax[m++];
            else if (less(ax[m], ax[n])) {
                a[i] = ax[m++];
            } else{
                a[i] = a[n++];
            }
        }
    }
}
