package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.TreeNode;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class T18Mirror {
    public void Mirror(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        dfs(root.left);
        dfs(root.right);
    }
}
