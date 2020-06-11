package com.djcao.alogic;

/**
 * 类型：希尔排序
 * 时间复杂度：N^2
 * 空间复杂度：1
 * 描述：插入排序的改进算法
 * 思想：
 * @author djcao
 * @date 2020-04-29 2:06
 */
public class ShellStrategy extends AbstractSortStrategy implements SortStrategy {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h +1;
        while (h >= 1) {
            for (int i = h; i < 2*h; i++) {
                for (int j = i; j > h; j-=h) {
                    if (less(a[j], a[j - h])) {
                        exch(a,j,j-h);
                    }
                }
            }
            h = h / 3;
        }
    }
}
