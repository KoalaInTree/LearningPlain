package com.djcao.algorithm;

/**
 * @author djcao
 * @date 2020-05-03 21:56
 */
public class ShellSortStrategy extends AbstractSortStrategy implements SortStrategy {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 0;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > 0 && less(a[j],a[j-h]); j-=h) {
                    swap(a,j,j-h);
                }
            }
            h /= 3;
        }
    }
}
