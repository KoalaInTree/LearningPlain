package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class T26Convert {
    static TreeNode head;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree, true);
        return head;
    }

    private static TreeNode dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, true);
        if (head == null) head = root;
        TreeNode right = dfs(root.right, false);

        root.left = left;
        if (left != null) {
            left.right = root;
        }
        root.right = right;
        if (right != null) {
            right.left = root;
        }
        if (isLeft) {
            return root.right == null ? root : root.right;
        } else {
            return root.left == null ? root : root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        node6.left = node4;
        node6.right = node7;
        node12.left = node11;
        node12.right = node13;
        node8.left = node6;
        node8.right = node12;

        System.out.println(Convert(node8));
    }
}
