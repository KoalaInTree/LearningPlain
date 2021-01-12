package com.djcao.leetcode.face.zj66;

public class T23VerifySequenceOfBST {
    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return dfs(0, sequence.length - 1, sequence);
    }

    private static boolean dfs(int left, int right, int[] sequence) {
        if (left >= right) {
            return true;
        }
        int rootVal = sequence[right];
        Integer mid_right = null, mid_left = null;
        for (int i = left; i < right; i++) {
            // 找到第一个右边节点
            if (sequence[i] > rootVal && mid_right == null) {
                mid_right = i;
            }
            //找到最后一个左节点
            if (sequence[i] < rootVal) {
                mid_left = i;
            }
        }
        // 不对
        if (mid_left != null && mid_right != null && mid_left>mid_right) {
            return false;
        }

        return (mid_left == null || dfs(left, mid_left, sequence)) && (mid_right == null || dfs(mid_right, right - 1, sequence));
    }

    public static void main(String[] args) {
        System.out.println(VerifySequenceOfBST(new int[]{4,8,6,12,16,14,10}));
    }
}
