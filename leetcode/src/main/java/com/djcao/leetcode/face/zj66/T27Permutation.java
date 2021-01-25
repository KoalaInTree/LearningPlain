package com.djcao.leetcode.face.zj66;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * 
 * "ab"
 * 返回值
 * 
 * ["ab","ba"]
 */
public class T27Permutation {

    static ArrayList<String> res = new ArrayList<>();
    static int N;

    public static ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        N = chars.length;
        Permutation(chars, new boolean[N], new StringBuffer());
        return res;
    }

    private static void Permutation(char[] chars, boolean[] hasUsed, StringBuffer stringBuffer) {
        if (N == stringBuffer.length()) {
            res.add(stringBuffer.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) continue;
            if (i != 0 && chars[i] == chars[i-1] && !hasUsed[i-1]) continue;
            stringBuffer.append(chars[i]);
            hasUsed[i] = true;

            Permutation(chars, hasUsed, stringBuffer);

            hasUsed[i] = false;
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation("aa"));
    }
}
