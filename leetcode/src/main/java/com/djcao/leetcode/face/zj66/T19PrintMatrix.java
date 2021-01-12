package com.djcao.leetcode.face.zj66;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 示例1
 * 输入
 * 复制
 * [[1,2],[3,4]]
 * 返回值
 * 复制
 * [1,2,4,3]
 */
public class T19PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        // colLeft:左上角 b右上角  c右下角 d左下角
        int colLeft = 0, colRight = matrix[0].length - 1, rowBottom = matrix.length - 1, rowTop = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (true ) {
            //top
            for (int i = colLeft; i <= colRight; i++) {
                res.add(matrix[rowTop][i]);
            }
            if (rowTop++ >= rowBottom) {
                break;
            }
            //右
            for (int i = rowTop; i <= rowBottom; i++) {
                res.add(matrix[i][colRight]);
            }
            if (colRight-- <= colLeft) {
                break;
            }
            //下
            for (int i = colRight; i >= colLeft; i--) {
                res.add(matrix[rowBottom][i]);
            }
            if (rowBottom-- <= rowTop) {
                break;
            }
            //左
            for (int i = rowBottom; i >= rowTop; i--) {
                res.add(matrix[i][colLeft]);
            }
            if (colLeft++ >= colRight) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(printMatrix(new int[][]{{1,2},{3,4}}));
    }

}
