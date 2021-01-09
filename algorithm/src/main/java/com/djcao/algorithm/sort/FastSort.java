package com.djcao.algorithm.sort;

import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-10-13 22:33
 */
public class FastSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        int base = arr[left];
        while (i < j) {
            while (j>i && arr[j]>=base){
                j--;
            }
            while (j>i && arr[i]<=base){
                i++;
            }
            SortHelper.swap(arr, i, j);
        }
        SortHelper.swap(arr,left, i);
        sort(arr, left, i-1);
        sort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();
        System.out.println(SortHelper.checkSort(fastSort::sort));;

    }


}
