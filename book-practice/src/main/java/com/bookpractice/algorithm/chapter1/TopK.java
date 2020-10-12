package com.bookpractice.algorithm.chapter1;

/**
 * @author djcao
 * @date 2020-09-05 23:02
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 3, 5, 1, 5, 4, 0, 7, 85, 4};
        int[] arr2 = {1, 3, 7, 5, 3, 5, 1, 5, 4, 0, 7, 85, 4};
        System.out.println(sortTopK(arr,1));
        System.out.println(littleSortTopK(arr2,2));
    }

    public static int sortTopK(int[] arr,int index) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]=tmp;
                }
            }
        }
        return arr[index-1];
    }

    public static int littleSortTopK(int[] arr,int index) {
        int[] res = new int[index];
        System.arraycopy(arr,0,res,0,index);
        for (int i = 0; i < res.length; i++) {
            for (int j = res.length - 1; j > i; j--) {
                if (res[j - 1] < res[j]) {
                    int tmp = res[j];
                    res[j] = res[j-1];
                    res[j-1]=tmp;
                }
            }
        }
        int min = res[index - 1];
        for (int x = index; x < arr.length; x++) {
            if (min < arr[x]) {
                res[index - 1] = arr[x];
                for (int i = res.length - 1; i > 0  ; i--) {
                    if (res[i] > res[i - 1]) {
                        int tmp = res[i];
                        res[i] = res[i-1];
                        res[i-1]=tmp;
                    }
                }
                min = res[index - 1];
            }
        }
        return res[index - 1];
    }
}
