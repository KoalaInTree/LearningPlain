package com.djcao.leetcode.face.zj66;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintListFromTailToHead {

    /**
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHeadO1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        ListNode prev = listNode, now = listNode.next,next;
        prev.next = null;
        while (now != null) {
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }


        while (prev != null) {
            res.add(prev.val);
            prev = prev.next;
        }

        return res;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> listNodes = new LinkedList<>();
        while (listNode != null) {
            listNodes.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!listNodes.isEmpty()) {
            res.add(listNodes.pop());
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        node1.next = node2;

        System.out.println(printListFromTailToHeadO1(node1));
    }
}
