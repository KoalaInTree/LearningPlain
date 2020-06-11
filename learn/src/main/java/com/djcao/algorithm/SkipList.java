package com.djcao.algorithm;

import java.util.Random;

/**
 * @author djcao
 * @date 2020-06-10 22:23
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 0;
    private Node head = new Node();
    private Random random = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1 ; i >= 0; i--) {
            while (p.getNext(i) != null && p.getNext(i).getValue() < value) {
                p = p.getNext(i);
            }
        }
        return p.getValue() == value ? p : null;
    }

    public Node insert(int value) {
        Node p = head;
        int level = randomLevel();
        Node node = new Node();
        node.setValue(value);

        Node[] updateArr = new Node[level];
        for (int i = level-1; i >= 0 ; i++) {
            while (p.getNext(i) != null && p.getNext(i).getValue() <value) {
                p = p.getNext(i);
            }
            updateArr[i] = p;
        }

        for (int i = 0; i < updateArr.length; i++) {
        }

    }

    private int randomLevel() {
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            level += random.nextInt() % 2;
        }
        return level;
    }


    public class Node {
        private Node[] next = new Node[MAX_LEVEL];
        private int value;

        public Node getNext(int i) {
            return next[i];
        }

        public void setNext(int i,Node node) {
            next[i] = node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
