package com.djcao.leetcode.face.lc.random;

import java.util.LinkedList;
import java.util.List;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/22
 */
public class FindString {

    public LinkedList<Pair<Integer, Integer>> findString(String[][] letters, String word) {
        LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();
        boolean[][] flag = new boolean[letters.length][];
        int p = 0;
        for (String[] x : letters) {
            flag[p++] = new boolean[x.length];
        }
        String[] split = word.split("");
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                if (find(letters, i, j, split,flag , stack)) {
                    return stack;
                }
            }
        }
        return null;
    }

    private boolean find(String[][] letters,int i, int j,
        String[] split,
        boolean[][] flag,
        LinkedList<Pair<Integer, Integer>> stack) {
        Pair<Integer, Integer> curPosition = new Pair<>(i, j);
        if (i < 0 || i >= letters.length || j < 0 || j >= letters[i].length) {
            return false;
        }
        if (letters[i][j].equals(split[stack.size()]) && !flag[i][j]) {
            stack.add(curPosition);
            flag[i][j] = true;
            if (stack.size() == split.length) {
                return true;
            }
            boolean b = find(letters, i, j + 1, split, flag, stack) ||
                find(letters, i, j - 1, split, flag, stack) ||
                find(letters, i - 1, j, split, flag, stack) ||
                find(letters, i + 1, j, split, flag, stack);
            if (!b) {
                stack.pop();
                flag[i][j] = false;
            }
            return b;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] letters = {{"a", "b", "c", "e", "f", "g"}, {"h", "i", "j", "k", "l", "m"},
            {"n", "o", "p", "q",
                "r", "s"}, {"t", "u", "v", "w", "x", "y"}};
        FindString findString = new FindString();
        String word = "abcefgmlkjihnopqrsyxwvut";
        LinkedList<Pair<Integer, Integer>> abc = findString.findString(letters, word);
        if (abc == null) {
            System.out.println("没找到");
            return;
        }
        String reduce = abc.stream().map(x -> letters[x.getK()][x.getV()])
            .reduce("", (a, b) -> a + b);
        System.out.println(reduce);
        System.out.println(reduce.equals(word));
    }

    public List<Integer> grayCode(int n) {
        int pow = Double.valueOf(Math.pow(2, n)).intValue();
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
        int i=1,j = 0;
        for(; j < n; i*=2,j++){
            if(j == 0 ){
                int x = cur % 2 == 1 ? -1 : 1;
                if(gray(stack,flag,cur+x,pow,n)){
                    return true;
                }
            }
            else {
                int x = cur % (4 * i) - cur % (2 * i) != 0 ? -1 : 1;
                if(gray(stack,flag,cur+x,pow,n)){
                    return true;
                }
            }
        }
        flag[cur] = false;
        stack.removeLast();
        return false;

    }
}
