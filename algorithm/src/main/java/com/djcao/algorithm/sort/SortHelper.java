package com.djcao.algorithm.sort;

/**
 * @author djcao
 * @date 2020-10-13 22:42
 */
public class SortHelper {
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static boolean isSort(int[] arr) {
        return isSort(arr, true);
    }

    public static boolean isSort(int[] arr,boolean asc) {
        int i = 1;
        while (i < arr.length) {
            if (asc ? arr[i - 1] > arr[i] : arr[i - 1] < arr[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean checkSort(Sort sort) {
        return checkSort(sort, true);
    }

    public static boolean checkSort(Sort sort,boolean asc) {
        int[] arr = {0};
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,2,1};
        int[] arr3 = {1,2};
        int[] arr4 = {2,1};
        int[] arr5 = {999999,2222,111,22222,3333,4444,555666,666666666};
        int[] arr6 = {0,0,0,0,0,0,0,0};
        int[] arr7 = {9,9,9,9,9,9,5};
        int[] arr8 = {11,22,3333,33,44444,55,6666};
        int[][] data = {arr, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
        for (int[] x : data) {
            sort.sort(x);
            boolean sort1 = isSort(x,asc);
            if (!sort1) {
                return false;
            }
        }
        return true;
    }

}
