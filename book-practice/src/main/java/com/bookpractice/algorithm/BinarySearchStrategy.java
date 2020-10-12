package com.bookpractice.algorithm;

/**
 * @author djcao
 * @date 2020-07-08 20:48
 */
public class BinarySearchStrategy {
    private static int search(int[] arr, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        int value = arr[mid];
        if (target > value) {
            return search(arr, target, mid + 1, hi);
        } else if (target < value) {
            return search(arr, target, lo, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 88, 122, 2342, 2342, 2342, 2342,23421,23422,23423,23423,23427};
        System.out.println(search(arr,2342,0,arr.length-1));
    }

}
