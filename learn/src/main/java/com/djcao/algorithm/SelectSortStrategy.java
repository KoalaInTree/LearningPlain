package com.djcao.algorithm;

/**
 * @author djcao
 * @date 2020-05-03 21:36
 */
public class SelectSortStrategy extends AbstractSortStrategy implements SortStrategy {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int now;
        for (int i = 0; i < N; i++) {
            now = i ;
            for (int j = i; j < N; j++) {
                if (less(a[j], a[now])) {
                    now = j;
                }
            }
            swap(a, i, now);
        }
    }
}
