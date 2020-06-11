package com.djcao.algorithm;

/**
 * @author djcao
 * @date 2020-05-03 21:30
 */
public interface SortStrategy {

    void sort(Comparable[] a);

    boolean isSort(Comparable[] a);

    void show(Comparable[] a);
}
