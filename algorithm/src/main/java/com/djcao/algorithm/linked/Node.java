package com.djcao.algorithm.linked;

/**
 * @author djcao
 * @date 2020-10-21 22:17
 */
public class Node {
    private Node after;
    private Node before;
    private int value;

    public Node getAfter() {
        return after;
    }

    public void setAfter(Node after) {
        this.after = after;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }
}
