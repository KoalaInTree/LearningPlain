package com.djcao.alogic;

/**
 * @author djcao
 * @date 2020-04-29 2:17
 */
public class Main {
    public static void main(String[] args) {
        //SortStrategy sortStrategy = new SelectSortStrategy();
        SortStrategy sortStrategy = new InsertSortStrategy();
        Comparable[] a = {1,9,3,5,7,1,3};
        sortStrategy.sort(a);
        assert sortStrategy.isSort(a);
        sortStrategy.show(a);
    }
}
