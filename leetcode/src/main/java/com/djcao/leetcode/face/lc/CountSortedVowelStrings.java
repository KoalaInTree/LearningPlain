package com.djcao.leetcode.face.lc;

import java.util.Arrays;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 *
 * 输入：n = 33
 * 输出：66045
 *  
 *
 * 提示：
 *
 * 1 <= n <= 50 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSortedVowelStrings {

    public static int countVowelStrings(int n) {
        int[] dp = new int[5];

        Arrays.fill(dp,1);
        int ans= 5;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                    ans = 0;
            }
            for (int j = 4; j >= 0; j--) {
                int cur = 0;
                for (int k = 0; k <= j; k++) {
                    cur += dp[k];
                }
                dp[j] = cur;
                if (i == n - 1) {
                    ans += cur;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(33));
    }
}
