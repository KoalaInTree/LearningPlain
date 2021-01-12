package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.TreeNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * 
 * {10,5,12,4,7},22
 * 返回值
 * 
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * 
 * {10,5,12,4,7},15
 * 返回值
 * 
 * []
 */
public class T24FindPath {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target);
        return paths;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (target == 0 && isLeaf) {
            paths.add((ArrayList<Integer>) path.clone());
        } else {
            dfs(root.left, target);
            dfs(root.right, target);
        }

        path.remove(path.size() - 1);
    }
}
