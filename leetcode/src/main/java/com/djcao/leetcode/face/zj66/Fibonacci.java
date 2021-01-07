package com.djcao.leetcode.face.zj66;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 *
 * 示例1
 * 输入
 *
 * 4
 * 返回值
 *
 * 3
 */
public class Fibonacci {

    public static int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        int a = 0, b = 1,c;
        for (int i = 2; i <= n; i++) {
            c = a +b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}
