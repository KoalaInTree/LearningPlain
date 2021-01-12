package com.djcao.leetcode.face.zj66;

import com.djcao.leetcode.face.common.RandomListNode;

import java.util.HashMap;
import java.util.Optional;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class T25Clone {
    // hash表解决
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode root = new RandomListNode(-1), res = root, prev = null;
        // random:target
        HashMap<RandomListNode, RandomListNode> cache = new HashMap<>();
        // raw:target
        HashMap<RandomListNode, RandomListNode> cache2 = new HashMap<>();
        while (pHead != null) {
            root.label = pHead.label;
            if (prev != null) {
                prev.next = root;
            }
            prev = root;
            cache2.put(pHead, root);
            if (pHead.random != null) {
                RandomListNode randomListNode = cache2.get(pHead.random);
                if (randomListNode != null) {
                    root.random = randomListNode;
                } else {
                    cache.put(pHead.random, root);
                }
            }

            RandomListNode randomListNode1 = cache.get(pHead);
            if (randomListNode1 != null) {
                randomListNode1.random = root;
            }
            root = new RandomListNode(-1);
            pHead = pHead.next;
        }

        return res;
    }

    // 原地解决
    public static RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //step1
        RandomListNode tmp, next, s1 = pHead;
        while (s1 != null) {
            tmp = new RandomListNode(s1.label);
            next = s1.next;
            s1.next = tmp;
            tmp.next = next;
            s1 = next;
        }


        //step2
        RandomListNode s2 = pHead;
        while (s2 != null) {
            if (s2.random != null) {
                s2.next.random = s2.random.next;
            }
            s2 = s2.next.next;
        }
        // step3
        RandomListNode s3 = pHead, res = pHead.next;
        while (s3 != null) {
            next = s3.next.next;
            s3.next.next = (next != null ? next.next : null);
            s3.next = next;
            s3 = next;
        }

        return res;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node2.random = node2;
        node.random = node2;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        RandomListNode root = Clone2(node);
        while (root != null) {
            System.out.println(root.label + " " + (root.random == null ? "null" : root.random.label));
            root = root.next;
        }
    }
}
