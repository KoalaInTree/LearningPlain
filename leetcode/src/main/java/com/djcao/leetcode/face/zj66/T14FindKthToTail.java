package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.ListNode;

import java.util.LinkedList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class T14FindKthToTail {
    // k可能大于节点个数
    public ListNode FindKthToTail(ListNode head, int k) {
        LinkedList<ListNode> cache = new LinkedList<>();
        while (head != null) {
            cache.addLast(head);
            head = head.next;
            if (cache.size() == k+1) {
                cache.removeFirst();
            }
        }
        return !cache.isEmpty()&&cache.size()==k ? cache.removeFirst() :null ;
    }
}
