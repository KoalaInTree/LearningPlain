package com.djcao.leetcode.face.lc.random;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/30
 */
public class LengthString {
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int b=1;
        int max = b;
        for(int i = 1; i < arr.length; i++){
            boolean equal = false;
            for(int j = i - 1; j >= (i - b); j--){
                if(arr[i] == (arr[j])){
                    equal = true;
                    b = i - j;
                    break;
                }
            }
            if(!equal)
                b = b + 1;
            max = Math.max(max,b);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
