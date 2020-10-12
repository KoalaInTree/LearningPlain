package com.djcao.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author djcao
 * @date 2020-08-22 22:48
 */
public class Tree {
    public static final Object NOT_VALUE_OBJECT = new Object();

    private Object[] nodes;

    private Node root;

    private Long deep;

    public Tree(Object[] nodes) {
        this.nodes = nodes;
    }

    public Long getDeep() {
        if (deep == null) {
            synchronized (this) {
                if (deep == null) {
                    calDeep();
                }
            }
        }
        return deep;
    }

    private void calDeep() {
        Node root = getRoot();
        deep = maxDeep(root);
    }

    private Long maxDeep(Node parent) {
        if (parent == null)
            return 0L;
        return Math.max(maxDeep(parent.getLeftNode()),maxDeep(parent.getRightNode())) + 1;
    }

    /**
     * 层级遍历
     * @param root
     */
    public static void levelTraverse(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.getValue());
            if (poll.getLeftNode() != null)
                queue.add(poll.getLeftNode());
            if (poll.getRightNode() != null)
                queue.add(poll.getRightNode());
        }
    }

    /**
     * 打印每层最左边的节点
     * @param root
     */
    public static void printLeftestNode(Node root) {
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                Node first = queue1.poll();
                addChildToQueue(first,queue2);
                System.out.println(first.getValue());
                while (!queue1.isEmpty()) {
                    addChildToQueue(queue1.poll(),queue2);
                }
            }

            while (!queue2.isEmpty()) {
                Node first = queue2.poll();
                addChildToQueue(first,queue1);
                System.out.println(first.getValue());
                while (!queue2.isEmpty()) {
                    addChildToQueue(queue2.poll(),queue1);
                }
            }
        }
    }

    private static void addChildToQueue(Node node, Queue<Node> queue) {
        if (node.leftNode != null)
            queue.add(node.leftNode);
        if (node.rightNode != null)
            queue.add(node.rightNode);
    }

    public Node getRoot() {
        if (root == null) {
            synchronized (NOT_VALUE_OBJECT) {
                if (root == null) {
                    buildTree();
                }
            }
        }
        return root;
    }

    private void buildTree() {
        root = new Node(nodes[0]);
        buildChild(root, 0);
    }

    private void buildChild(Node parent,int index) {
        if (2 * index + 1< nodes.length && nodes[2 * index + 1] != NOT_VALUE_OBJECT) {
            parent.leftNode = new Node(nodes[index * 2 + 1]);
            buildChild(parent.leftNode, 2 * index + 1);
        }
        if (2 * index + 2 < nodes.length && nodes[2 * index + 2] != NOT_VALUE_OBJECT) {
            parent.rightNode = new Node(nodes[index * 2 + 2]);
            buildChild(parent.rightNode, 2 * index + 2);
        }
    }

    @Data
    @AllArgsConstructor
    public class Node {
        public Node(Object value) {
            this.value = value;
        }

        private Node leftNode;

        private Node rightNode;

        private Object value;
    }

}
