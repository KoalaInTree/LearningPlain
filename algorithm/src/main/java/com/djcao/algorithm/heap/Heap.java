package com.djcao.algorithm.heap;

import java.util.Arrays;

/**
 * @author djcao
 * @date 2020-10-13 21:16
 */
public class Heap {
    public int[] arr;

    public Heap() {
    }

    public Heap(int[] arr) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        buildHeap(this.arr);
    }

    public void buildHeap(int[] arr) {
        buildHeap(arr, arr.length);
    }

    public void buildHeap(int[] arr,int end) {
        int left;
        int right;
        int tmp;
        for (int i = end / 2 + 1; i >= 0 ; i--) {
            left = i * 2 + 1;
            right = i * 2 + 2;
            if (left < end && arr[i] > arr[left]) {
                tmp = arr[i];
                arr[i] = arr[left];
                arr[left] = tmp;
            }

            if (right < end && arr[i] > arr[right]) {
                tmp = arr[i];
                arr[i] = arr[right];
                arr[right] = tmp;
            }
        }
    }

    public int poll() {
        int res = arr[0];
        arr[0] = arr[arr.length - 1];
        buildHeap(arr, arr.length - 1);
        return res;
    }

    public void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void add(int x) {
        int[] new_arr = new int[arr.length + 1];
        System.arraycopy(arr, 0, new_arr, 0, arr.length);
        if (x < arr[0]) {
            new_arr[arr.length] = arr[0];
            new_arr[0] = x;
        }else {
            new_arr[arr.length] = x;
        }
        arr = new_arr;
    }

    @Override
    public String toString() {
        return "Heap{" +
            "arr=" + Arrays.toString(arr) +
            '}';
    }

    public static void main(String[] args) {
        int[] arr = {2,7,1,8,2,4,2,1,8,0};
        Heap heap = new Heap(arr);
        System.out.println(heap);
        heap.add(-1);
        System.out.println(heap);
        int poll = heap.poll();
        System.out.println(poll == -1);
        System.out.println(heap);
    }

}
