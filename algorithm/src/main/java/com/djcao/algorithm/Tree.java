package com.djcao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/25
 */
public class Tree {

    public Node root;

    private int[] source;

    public Tree() {
    }

    public Tree(int[] arr){
        root = build(arr);
        source = arr;
    }

    public Node build(int[] arr) {
       return link(arr, 0);
    }

    private Node link(int[] arr, int cur) {
        if (cur <0 || cur > arr.length - 1){
            return null;
        }
        Node node = new Node(arr[cur]);
        node.left = link(arr,cur*2 + 1);
        node.right = link(arr,cur*2 + 2);
        return node;
    }

    public List<Integer> preOrder() {
        return preOrderInner(root, new ArrayList<>());
    }

    private List<Integer> preOrderInner(Node root,List<Integer> order) {
        if (root == null) {
            return null;
        }
        order.add(root.val);
        preOrderInner(root.left, order);
        preOrderInner(root.right, order);
        return order;
    }

    public List<Integer> midOrder() {
        return midOrderInner(root, new ArrayList<>());
    }

    private List<Integer> midOrderInner(Node root,List<Integer> order) {
        if (root == null) {
            return null;
        }
        midOrderInner(root.left, order);
        order.add(root.val);
        midOrderInner(root.right, order);
        return order;
    }

    public List<Integer> postOrder() {
        return postOrderInner(root, new ArrayList<>());
    }

    private List<Integer> postOrderInner(Node root,List<Integer> order) {
        if (root == null) {
            return null;
        }
        postOrderInner(root.left, order);
        postOrderInner(root.right, order);
        order.add(root.val);
        return order;
    }

    public List<Integer> levelOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
        return res;
    }

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Tree tree = new Tree(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(tree.preOrder());
        System.out.println(tree.midOrder());
        System.out.println(tree.postOrder());
        System.out.println(tree.levelOrder());
    }
}
