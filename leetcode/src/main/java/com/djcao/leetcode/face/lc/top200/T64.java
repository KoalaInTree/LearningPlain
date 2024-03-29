package com.djcao.leetcode.face.lc.top200;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class T64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];

        int left,right;
        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                left = Integer.MAX_VALUE;
                right = left;
                // dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + grid[i][j];
                if(j-1>=0){
                    left = dp[i][j-1];
                }

                if(i-1>=0){
                    right = dp[i-1][j];
                }
                dp[i][j]=Math.min(left,right) + grid[i][j];

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
