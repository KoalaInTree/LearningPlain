package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.ListNode;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入
 * 复制
 * {1,3,5},{2,4,6}
 * 返回值
 * 复制
 * {1,2,3,4,5,6}
 */
public class T16Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-9999), root = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
               head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        ListNode a = list1 != null ? list1 : list2;
        if (a != null) {
            head.next = a;
        }
        return root.next;
    }
}
