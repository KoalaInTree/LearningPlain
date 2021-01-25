package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * <p>
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * <p>
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class T30FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int N = array.length;
        int[] dp = new int[N];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}
