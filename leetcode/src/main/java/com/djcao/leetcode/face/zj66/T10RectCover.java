package com.djcao.leetcode.face.zj66;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class T10RectCover {
    public static int rectCover(int target) {
        if (target == 0) {
            return 0;
        }
        int a = 1, b = 1, c;
        for (int i = 2; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(rectCover(4));
    }
}
