package com.djcao.leetcode.face.test;

import com.djcao.leetcode.face.common.RandomListNode;

import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    public static Node copyRandomList(Node pHead) {
        if (pHead == null) {
            return null;
        }
        Node root = new Node(-1), res = root, prev = null;
        // random:target
        HashMap<Node, Node> cache = new HashMap<>();
        // raw:target
        HashMap<Node, Node> cache2 = new HashMap<>();
        while (pHead != null) {
            root.val = pHead.val;
            if (prev != null) {
                prev.next = root;
            }
            prev = root;
            cache2.put(pHead, root);
            if (pHead.random != null) {
                Node randomListNode = cache2.get(pHead.random);
                if (randomListNode != null) {
                    root.random = randomListNode;
                } else {
                    cache.put(pHead.random, root);
                }
            }

            Node randomListNode1 = cache.get(pHead);
            if (randomListNode1 != null) {
                randomListNode1.random = root;
            }
            root = new Node(-1);
            pHead = pHead.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node2.random = node2;
        node.random = node2;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node root = copyRandomList(node);
        while (root != null) {
            System.out.println(root.val + " " + (root.random == null ? "null" : root.random.val));
            root = root.next;
        }
    }

    static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
}