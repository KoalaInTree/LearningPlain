package com.djcao.algorithm.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author djcao
 * @date 2020-10-21 22:18
 */
public class LinkedNode {
    private Node head;
    private Node tail;
    public LinkedNode(int[] arr) {
        for (int i : arr) {
            add(i);
        }
    }

    public void removeAll(int value) {
        findAll(value).forEach(this::remove);
    }

    public Node find(int val) {
        Node p = head;
        while (p != null) {
            if (p.getValue() == val) {
                return p;
            }
            p = p.getAfter();
        }
        return null;
    }

    public List<Node> findAll(int val) {
        Node p = head;
        List<Node> res = new ArrayList<>();
        while (p != null) {
            if (p.getValue() == val) {
                res.add(p);
            }
            p = p.getAfter();
        }
        return res;
    }

    public Node add(int value) {
        Node node = new Node();
        node.setValue(value);
        if (tail == null) {
            tail = node;
            head = node;
        }else {
            tail.setAfter(node);
            node.setBefore(tail);
            tail = node;
        }
        return node;
    }

    public void remove(Node node) {
        Node p = node,a=node.getBefore(),b=node.getAfter();
        if (head == tail && node == head) {
            head = null;
            tail = null;
        } else if (node == head) {
            node.setAfter(null);
            b.setBefore(null);
            head = b;
        } else if (node == tail) {
            a.setAfter(null);
            b.setBefore(null);
            tail = a;
        } else {
            a.setAfter(b);
            b.setBefore(a);
            node.setAfter(null);
            node.setBefore(null);
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        Node h = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (h != null) {
            stringBuilder.append(h.getValue()).append(" ");
            h = h.getAfter();
        }
        return stringBuilder.toString();
    }
}

