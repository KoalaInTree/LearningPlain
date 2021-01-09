package com.djcao.algorithm.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author djcao
 * @date 2020-10-24 12:39
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(0, 100).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        PriorityQueue<Integer> queue = new PriorityQueue<>(ints);
    }
}
