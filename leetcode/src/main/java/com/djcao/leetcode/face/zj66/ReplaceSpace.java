package com.djcao.leetcode.face.zj66;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int N = str.length();
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == ' ') {
                str.append("12");
            }
        }

        int i = N - 1;
        int j = str.length() - 1;
        char c;
        while (i >= 0 && j>i) {
            c = str.charAt(i--);
            if (c == ' ') {
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }else {
                str.setCharAt(j--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("a b cddd")));
    }
}
