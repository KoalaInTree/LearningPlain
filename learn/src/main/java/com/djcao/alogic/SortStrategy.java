package com.djcao.alogic;

import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-04-29 2:05
 */
public interface SortStrategy {

    void sort(Comparable[] a);

    boolean isSort(Comparable[] a);

    void show(Comparable[] a);
}
