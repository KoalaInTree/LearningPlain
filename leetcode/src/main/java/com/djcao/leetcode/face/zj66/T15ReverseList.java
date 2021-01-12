package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.ListNode;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入
 * 复制
 * {1,2,3}
 * 返回值
 * 复制
 * {3,2,1}
 */
public class T15ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
