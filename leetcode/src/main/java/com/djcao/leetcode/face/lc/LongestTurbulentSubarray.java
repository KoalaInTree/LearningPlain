package com.djcao.leetcode.face.lc;

import java.util.Map;

/**
 * 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
 *
 * 若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 * 
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestTurbulentSubarray {

    public static int maxTurbulenceSize(int[] arr) {

        int N = arr.length;
        int f = 1;
        int g = 1;
        int ans = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) {
                f = 1;
                g = 1;
            } else if (arr[i] - arr[i - 1] > 0) {
                f = g + 1;
                g = 1;
            } else {
                g = f + 1;
                f = 1;
            }
            ans = Math.max(ans, f);
            ans = Math.max(ans, g);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
    }
}
