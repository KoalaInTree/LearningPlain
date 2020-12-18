package com.djcao.leetcode.face;

import java.util.*;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 */
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //从src到达节点的费用
        HashMap<Integer, HashMap<Integer, Integer>> fees = new HashMap<>(n);
        for (int[] flight : flights) {
            HashMap<Integer, Integer> longLongHashMap = fees.computeIfAbsent(flight[0], k -> new HashMap<>(2));
            longLongHashMap.put(flight[1], flight[2]);
        }

        // 费用小的在前面
        PriorityQueue<int[]> notProcessQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        notProcessQueue.add(new int[]{0,0,src});
        while (!notProcessQueue.isEmpty()) {
            // 获取最小费用的城市
            int[] poll = notProcessQueue.poll();
            int cost = poll[0], k = poll[1], city = poll[2];

            if (city == dst) {
                return cost;
            }
            if (k > K) {
                continue;
            }
            HashMap<Integer, Integer> neighbors = fees.get(city);
            if (neighbors == null) continue;
            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                Integer neighborCity = entry.getKey();
                Integer neighborCost = entry.getValue();
                notProcessQueue.add(new int[]{cost + neighborCost, k + 1, neighborCity});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int  n = 5, src = 0, dst = 2, k = 2;
        int[][] edges = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        System.out.println(findCheapestPrice(n, edges, src, dst, k));
    }
}
