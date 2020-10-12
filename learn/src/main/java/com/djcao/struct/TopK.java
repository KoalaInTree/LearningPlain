package com.djcao.struct;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 */
public class TopK {

    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 4, 1, 0, 88, 66, 55};
        System.out.println(topK(arr, 8));
    }

    public static int topK(int[] arr, int index) {
        int[] res = new int[index+1];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i < arr.length; i++) {
            if (res[index] < arr[i]) {
                res[index] = arr[i];
                for (int j = index; j > 0 ; j--) {
                    if (res[j - 1] < res[j]) {
                        swap(res, j-1, j);
                    }
                }
            }
        }
        return res[index];
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
