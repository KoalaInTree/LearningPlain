package com.djcao.leetcode.face.zj66;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1
 * 输入
 * 复制
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * 复制
 * true
 */
public class T01Find {
    public static boolean Find2(int target, int [][] array) {
        int X = array[0].length, Y = array.length;
        int x = 0, y = Y - 1,value;
        while (x<X && y >=0){
            value = array[y][x];
            if (value == target) {
                return true;
            } else if (value > target) {
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
    public static boolean FindForce(int target, int [][] array) {
        for (int[] item : array) {
            if (binarySearch(item, target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {
        int a = 0, b = arr.length - 1,mid;
        while (a <= b) {
            mid = a + ((b - a) / 2);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Find2(15,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
        System.out.println(Find2(2,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
        System.out.println(Find2(3,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
        System.out.println(Find2(4,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
        System.out.println(Find2(5,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
        System.out.println(Find2(11,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
    }
}
