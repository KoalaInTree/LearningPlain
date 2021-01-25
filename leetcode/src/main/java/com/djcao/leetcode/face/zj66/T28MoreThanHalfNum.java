package com.djcao.leetcode.face.zj66;

import java.util.HashMap;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * 
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 
 * 2
 *
 * 多数投票问题。
 */
public class T28MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int N = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            Integer orDefault = map.getOrDefault(item, 0);
            if (orDefault + 1 > N) return item;
            map.put(item, orDefault + 1);
        }
        return 0;
    }

    public static int MoreThanHalfNum(int[] array) {//多数投票问题
        int num = array[0];
        int count = 1;

        for(int i = 1; i < array.length; i ++) {
        	if(array[i] == num) {
        		count ++;
        	} else {
        		count --;
        	}
    		if(count == 0) {
    			num = array[i];
    			count = 1;
    		}
        }

        count = 0;
        for(int val: array) {
        	if(val == num) {
        		count ++;
        	}
        }

        return count > array.length / 2 ? num : 0;//三元
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum(new int[]{1, 2, 2, 3, 4, 5, 6}));
    }
}
