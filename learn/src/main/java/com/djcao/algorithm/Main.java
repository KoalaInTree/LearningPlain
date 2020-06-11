package com.djcao.algorithm;

/**
 * @author djcao
 * @date 2020-05-03 21:44
 */
public class Main {

    public static void main(String[] args) {
        SortStrategy sortStrategy = new ShellSortStrategy();
        Comparable[] a = {1, 5, 1, 3, 7, 8, 5, 6, 9, 0, 4, 2};
        sortStrategy.sort(a);
        assert sortStrategy.isSort(a);
        sortStrategy.show(a);

    }
}
