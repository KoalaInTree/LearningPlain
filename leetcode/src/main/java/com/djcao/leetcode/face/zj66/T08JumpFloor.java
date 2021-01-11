package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 
 * 1
 * 返回值
 * 
 * 1
 * 示例2
 * 输入
 * 
 * 4
 * 返回值
 * 
 * 5
 */
public class T08JumpFloor {
    public static int JumpFloor(int target) {
        int a = 1, b = 1,c;
        for (int i = 2; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}
