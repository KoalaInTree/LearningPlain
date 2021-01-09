package com.djcao.algorithm.sort;

import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-10-13 22:14
 */
public class MergeSort {

    public void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1, tmp);
    }

    public void sort(int[] arr, int left, int right, int[] tmp) {
        int mid = (left + right) / 2;
        if (left < right) {
            sort(arr, left, mid, tmp);
            sort(arr, mid + 1, right, tmp);
            merge(arr, left, right, mid, tmp);
        }
    }

    public void merge(int[] arr, int left, int right, int mid, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            tmp[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= right) {
            tmp[index++] = arr[j++];
        }

        while (left <= right) {
            arr[left] = tmp[left];
            left++;
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        System.out.println(SortHelper.checkSort(sort::sort));;
    }

}
