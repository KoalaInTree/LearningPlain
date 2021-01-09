package com.djcao.algorithm.sort;

import java.util.Arrays;

import com.djcao.algorithm.heap.Heap;

/**
 * @author djcao
 * @date 2020-10-13 21:39
 */
public class HeapSort {


    public int[] sort(int[] arr) {
        Heap heap = new Heap();
        heap.buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            SortHelper.swap(arr,0, i);
            heap.buildHeap(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        System.out.println(SortHelper.checkSort(sort::sort,false));;
    }
}
