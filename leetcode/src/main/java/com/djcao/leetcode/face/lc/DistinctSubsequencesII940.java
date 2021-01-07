package com.djcao.leetcode.face.lc;

import java.util.Arrays;

/**
 * 给定一个字符串S，计算S的不同非空子序列的个数。
 *
 * 因为结果可能很大，所以返回答案模 10^9 + 7.
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 *
 * 输入："aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 *
 * 输入："aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubsequencesII940 {
    public static int distinctSubseqII(String S) {
        int[] last = new int[26];
        Arrays.fill(last,-1);
        int mod = 1_000_000_007;
        int[] dp = new int[S.length()+1];
        dp[0] = 1;
        for (int i = 0; i < S.length(); i++) {
            int x =S.charAt(i) -'a';

            dp[i+1] = (dp[i] * 2) % mod;
            if (last[x] != -1) {
                dp[i+1] -= dp[last[x]-1];
            }
            dp[i+1] %= mod;
            last[x] = i+1;
        }

        dp[S.length()]--;
        if(dp[S.length()] < 0) dp[S.length()] += mod;
        return dp[S.length()];
    }

    public static void main(String[] args) {
        System.out.println(-5 % 6);
        System.out.println(-6 % 6);
        System.out.println(-7 % 6);
//        System.out.println(distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
    }
}
