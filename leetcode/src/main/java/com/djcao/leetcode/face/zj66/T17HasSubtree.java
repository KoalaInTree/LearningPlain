package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.TreeNode;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入
 * 复制
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值
 * 复制
 * true
 */
public class T17HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return dfs(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return true;
        } else if (root1.val != root2.val) {
            return false;
        } else {
            return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
        }
    }
}
