package com.djcao.algorithm.linked;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author djcao
 * @date 2020-10-21 22:16
 */
public class LinkedSum {
    public LinkedNode sum(LinkedNode a, LinkedNode b) {
        int i = toInt(a);
        int i1 = toInt(b);
        int i2 = i + i1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int mod = 10;
        int base = 1;
        while (i2 != 0) {
            base *= mod;
            int v = i2 % (base);
            arrayList.add(v/(base / mod));
            i2 -= v;
        }
        int[] ints = arrayList.stream().mapToInt(x -> x).toArray();
        return new LinkedNode(ints);
    }

    private int toInt(LinkedNode linkedNode) {
        int a = 0;
        Node node = linkedNode.getHead();
        int position = 0;
        while (node != null) {
            a += node.getValue() * Math.pow(10, position++);
            node = node.getAfter();
        }
        return a;
    }

    public static void main(String[] args) {
        LinkedSum linkedSum = new LinkedSum();
        LinkedNode a = new LinkedNode(new int[]{3,1,5});
        LinkedNode b = new LinkedNode(new int[]{5,9,2});
        System.out.println(linkedSum.sum(a,b));
    }


}
