package com.bookpractice.algorithm.tree;

import java.util.List;

/**
 * @author djcao
 * @date 2020-07-09 23:56
 */
public class TreeToArr {
    static TreeNode root = new TreeNode();
    public static void main(String[] args) {


    }

    public int getTreeMaxHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int i = getTreeMaxHeight(treeNode.getLeftChild()) + 1;
        int i2 = getTreeMaxHeight(treeNode.getRightChild()) + 1;
        return Math.max(i, i2);

    }
}
