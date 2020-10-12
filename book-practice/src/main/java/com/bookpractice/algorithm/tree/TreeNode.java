package com.bookpractice.algorithm.tree;

import java.io.Serializable;

/**
 * @author djcao
 * @date 2020-07-09 23:49
 */
public class TreeNode implements Serializable {
    private static final long serialVersionUID = -8803491895145148329L;
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
