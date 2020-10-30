package com.djcao.leetcode.face;

import java.util.LinkedList;
import java.util.List;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/25
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        int pow = getPow(n);
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] flag = new boolean[pow];
        gray(stack,flag,0,pow,n);
        return stack;
    }

    public boolean gray(LinkedList<Integer> stack,boolean[] flag,int cur,int pow,int n){

        if(flag[cur]){
            return false;
        }

        flag[cur] = true;
        stack.addLast(cur);
        if(stack.size() == pow){
            return true;
        }

        for( int j = 0; j < n;j++){
            if(gray(stack,flag,cur^getPow(j),pow,n)){
                return true;
            }
        }
        flag[cur] = false;
        stack.removeLast();
        return false;

    }

    private int getPow(int n){
        return Double.valueOf(Math.pow(2, n)).intValue();
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> integers = grayCode.grayCode(2);
        System.out.println(8^1);
    }
}
