package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * 复制
 * {1,2,5,3,4,6,7}
 */
public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        TreeNode res = bfs(pre, in, 0, pre.length-1, 0, in.length-1);
        return res;
    }

    private static TreeNode bfs(int[] pre, int[] in, int p_l, int p_r, int i_l, int i_r) {
        if (p_l > p_r) {
            return null;
        }
        int pos = -1;
        for (int i = i_l; i <= i_r; i++) {
            if (in[i] == pre[p_l]) {
                pos = i;
                break;
            }
        }

        TreeNode root = new TreeNode(pre[p_l]);
        root.left = bfs(pre, in, p_l + 1, p_l + 1 + (pos - i_l) - 1, i_l, pos-1);
        root.right = bfs(pre, in, p_l + 1 + (pos - i_l), p_r, pos + 1, i_r);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7}));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
