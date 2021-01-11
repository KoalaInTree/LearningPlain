package com.djcao.leetcode.face.zj66;

import java.util.Arrays;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class T13ReOrderArray {
    public static void reOrderArray(int[] array) {
        int odd = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        int[] clone = array.clone();
        int oddIndex = 0, eventIndex = odd;
        for (int i : clone) {
            if (i % 2 == 1) {
                array[oddIndex++] = i;
            } else {
                array[eventIndex++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        reOrderArray(ints);
        System.out.println(Arrays.toString(ints));;
    }
}
