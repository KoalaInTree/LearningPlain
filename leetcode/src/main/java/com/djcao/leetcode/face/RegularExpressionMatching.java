package com.djcao.leetcode.face;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * 
 *
 * 提示：
 *
 * 0 <= s.length<= 20
 * 0 <= p.length<= 30
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * 保证每次出现字符* 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RegularExpressionMatching {
     public static boolean isMatch(String s, String p) {
         int N = p.length();
         int T = s.length();
         int[][] dp = new int[N+1][T+1];
         boolean[][] dpp = new boolean[N+1][T+1];
         for (int i = 1; i <= N; i++) {
             for (int j = 1; j <= T; j++) {
                 if (p.charAt(i-1) == '*' ) {
                     if (dpp[i-1][j]) {
                         dp[i][j] = Math.min(j, Math.max(dp[i - 1][j],dp[i][j-1]) + 1);
                     }else {
                         dp[i][j] = Math.max(dp[i - 1][j],dp[i][j-1]);
                     }
                 }else if(p.charAt(i-1) == '.'){
                    dp[i][j] = Math.min(j, dp[i - 1][j] + 1);
                    dpp[i][j] = true;
                 }
                 else {
                     boolean equal = p.charAt(i - 1) == s.charAt(j - 1);
                     dp[i][j] = dp[i-1][j] + (equal ? 1 : 0);
                     dpp[i][j] = equal;
                 }

             }
         }
         return dp[N][T] == T;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*p*."));
    }
}
