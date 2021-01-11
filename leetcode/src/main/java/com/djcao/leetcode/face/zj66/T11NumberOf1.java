package com.djcao.leetcode.face.zj66;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class T11NumberOf1 {
    public static int NumberOf1(int n) {
        return Integer.bitCount(n);
    }

    /**
     * n            10000100
     * n-1          10000011
     * n & n-1      10000000
     * @param n
     * @return
     */
    public static int NumberOf11(int n) {
        int sum = 0;
        while (n != 0) {
            n &= n - 1;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf11(-1));
    }
}
