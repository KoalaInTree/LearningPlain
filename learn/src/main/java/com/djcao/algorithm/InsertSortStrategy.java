package com.djcao.algorithm;

/**
 * @author djcao
 * @date 2020-05-03 21:50
 */
public class InsertSortStrategy extends AbstractSortStrategy implements SortStrategy {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j >0 && less(a[j],a[j-1]); j--) {
                swap(a,j,j-1);
            }
        }
    }
}
