package com.djcao.leetcode.face.lc;

/**
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 *
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 *
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDotProductOfTwoSubsequences1458 {

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int xij = nums1[i] * nums2[j];
                dp[i][j] = xij;
                if(i >0){
                     dp[i][j] =  Math.max(dp[i][j],dp[i-1][j]);
                }
                if(j >0){
                     dp[i][j] =  Math.max(dp[i][j],dp[i][j-1]);
                }
                if(i>0 && j >0){
                     dp[i][j] =  Math.max(dp[i][j],dp[i-1][j-1] + xij );
                }
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }

    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5}, nums2 = {3,0,-6};
        System.out.println(maxDotProduct(nums1,nums2));
    }
}
