package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 
 * 3
 * 返回值
 * 
 * 4
 */
public class JumpFloorII {

    public int JumpFloorII(int target) {
        int a = 1;
        for (int i = 2; i <= target; i++) {
            a *= 2;
        }
        return a;
    }
}
