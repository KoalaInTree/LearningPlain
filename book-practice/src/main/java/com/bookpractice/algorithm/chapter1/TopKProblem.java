package com.bookpractice.algorithm.chapter1;

import com.bookpractice.algorithm.helper.AbstractSort;

/**
 * 求有N个数的数组中最大第K个的数
 * @author djcao
 * @date 2020-05-10 21:05
 */
public class TopKProblem extends AbstractSort {

    // 使用归并排序
    public void findBySort(Comparable[] a){

    }

    public void mergeSort(Comparable[] a,int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);

    }
}
