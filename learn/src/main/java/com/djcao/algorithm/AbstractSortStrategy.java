package com.djcao.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-05-03 21:30
 */

public abstract class AbstractSortStrategy {

    public boolean less(Comparable a , Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean lessAndEq(Comparable a , Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
