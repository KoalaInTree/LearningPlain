package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * 复制
 * [3,4,5,1,2]
 * 返回值
 * 复制
 * 1
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        int N = array.length;
        int right = N - 1, left = 0,mid;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                return array[right];
            }
            mid = (left + right) / 2;
            if (array[mid] >= array[left]) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
}
