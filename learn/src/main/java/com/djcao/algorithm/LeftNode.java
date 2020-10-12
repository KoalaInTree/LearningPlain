package com.djcao.algorithm;

import java.util.List;

/**
 * @author djcao
 * @date 2020-08-22 22:30
 */
public class LeftNode {

    public static void main(String[] args) {
        Object[] nodes = {1};
        Tree tree = new Tree(nodes);
        Tree.Node root = tree.getRoot();
        Tree.levelTraverse(root);
        Tree.printLeftestNode(root);
        System.out.println(tree.getDeep());
    }

}
