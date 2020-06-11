package com.bookpractice.algorithm.helper;

/**
 * @author djcao
 * @date 2020-05-10 21:16
 */
public class AbstractSort {
    public boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    public void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public boolean isSort(Comparable[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if (!less(a, i, i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void print(Comparable[] a) {
        for (Comparable tmp : a) {
            System.out.print(tmp + " ");
        }
    }
}
