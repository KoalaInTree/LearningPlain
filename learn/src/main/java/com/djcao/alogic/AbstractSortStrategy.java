package com.djcao.alogic;

import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-04-29 2:10
 */
public abstract class AbstractSortStrategy implements SortStrategy {

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean isSort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (!less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Comparable[] a) {
        Arrays.stream(a).forEach(System.out::println);
    }
}
