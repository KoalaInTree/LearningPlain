package com.djcao.leetcode.face.ms;

import com.djcao.leetcode.face.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumTree {
    static LinkedList<Integer> path = new LinkedList<Integer>();
    static List<LinkedList<Integer>> paths = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(13);
        TreeNode node9 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        TreeNode node3 = new TreeNode(11);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        right.setLeft(node4);

        left.setLeft(node3);
        node3.setLeft(node9);
        node3.setRight(node6);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        right.setRight(node5);
        node5.setLeft(node7);
        node5.setRight(node8);
        TreeNode root = new TreeNode(5);
        root.setLeft(left);
        root.setRight(right);
        dfs(root, 22);
        System.out.println(paths);
    }

    public static void dfs(TreeNode node, int sum) {
        path.addLast(node.getVal());
        boolean isLeaf = node.getLeft() == null && node.getRight() == null;
        sum -= node.getVal();
        if (isLeaf) {
            if (sum == 0)
                paths.add((LinkedList<Integer>) path.clone());
        } else {
            if (node.getLeft() != null) {
                dfs(node.getLeft(), sum);
            }
            if (node.getRight() != null) {
                dfs(node.getRight(), sum);
            }
        }
        path.removeLast();
    }
}
