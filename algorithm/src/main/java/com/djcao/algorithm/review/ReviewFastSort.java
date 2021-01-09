package com.djcao.algorithm.review;

import java.util.TreeMap;

import com.djcao.algorithm.sort.Sort;
import com.djcao.algorithm.sort.SortHelper;

/**
 * @author djcao
 * @date 2020-10-23 23:40
 */
public class ReviewFastSort implements Sort {
    public void fastSort(int[] nums,int left,int right){
        if(left > right){
            return;
        }
        int mid_value = nums[left];
        int low = left,high = right;
        while(low < high){
            while(low < high && nums[high] > mid_value){
                high--;
            }
            while(low < high && nums[low] <= mid_value){
                low++;
            }
            if(low != high){
                swap(nums,low,high);
            }
        }
        swap(nums,low,left);
        fastSort(nums,left,low-1);
        fastSort(nums,low+1,right);
    }

    private void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        ReviewFastSort fastSort = new ReviewFastSort();
        System.out.println(SortHelper.checkSort(fastSort));;
    }

    @Override
    public void sort(int[] arr) {
        fastSort(arr, 0, arr.length - 1);
    }
}
