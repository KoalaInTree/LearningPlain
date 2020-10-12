package com.djcao.algorithm.struct;

/**
 * @author djcao
 * @date 2020-09-05 18:36
 */
public class DJLinkedList {

    private Node head;

    public static void main(String[] args) {
        DJLinkedList DJLinkedList = new DJLinkedList(1,3,4,5,6);
        System.out.println(DJLinkedList.toString());
        DJLinkedList.reverse();
        System.out.println(DJLinkedList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            stringBuilder.append(tmp + ",");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }

    public DJLinkedList(Object ...vals) {
        for (Object val:vals) {
            Node node = new Node(val,null);
            if (head == null) {
                head = node;
            } else {
                node.setNext(head);
                head = node;
            }
        }
    }

    public void reverse() {
        Node pre = null, tmp = head;
        while (tmp!= null) {
            Node next = tmp.next;
            tmp.setNext(pre);
            pre = tmp;
            tmp = next;
        }
        head = pre;
    }

    public class Node{
        private Object value;
        private Node next;

        public Node(Object value,Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value ;
        }
    }
}
