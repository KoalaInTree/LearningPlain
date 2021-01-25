package com.djcao.leetcode.face.zj66;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class T29GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int item : input) {
            if (queue.size() == k) {
                if (queue.peek() > item) {
                    queue.poll();
                    queue.offer(item);
                }
            } else {
                queue.offer(item);
            }
        }

        return queue.size() < k ? new ArrayList<>() : new ArrayList<>(queue);
    }

}
