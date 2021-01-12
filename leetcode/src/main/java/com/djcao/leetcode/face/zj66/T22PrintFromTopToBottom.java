package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
示例1
输入

{5,4,#,3,#,2,#,1}
返回值

[5,4,3,2,1]
 */
public class T22PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return res;
    }
}
