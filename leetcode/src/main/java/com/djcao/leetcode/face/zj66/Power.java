package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * 
 * 2,3
 * 返回值
 * 
 * 8.00000
 */
public class Power {

    public static double Power2(double base, int exponent) {
        double res = 1;
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }

    /**
     * x^n = (x * x)^(n/2)
     * 时间复杂度是logn
     */
    public static double Power(double base, int exponent) {

        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }

        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

       double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow *= base;
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(Power(2, 3));
    }
}
