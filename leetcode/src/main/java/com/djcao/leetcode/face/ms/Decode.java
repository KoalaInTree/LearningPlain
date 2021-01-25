package com.djcao.leetcode.face.ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Decode {
    public static String decode(String encode) {
        LinkedList<Character> stack = new LinkedList<>();
        Character left = '[';
        Character right = ']';

        char[] chars = encode.toCharArray();
        for (char item : chars) {
            if (item != right) {
                stack.push(item);
            } else {
                // 找到了 ]
                ArrayList<Character> characterList = new ArrayList<>();
                // 找到被[] 包含的字符
                Character character;
                while (true) {
                    character = stack.pop();
                    // 找到了 [
                    if (!left.equals(character)) {
                        characterList.add(character);
                    }else {
                        break;
                    }
                }
                if (characterList.isEmpty()) {
                    continue;
                }
                // 找到重复的次数
                String  numString = new String();
                while (!stack.isEmpty()) {
                    character = stack.pop();
                    // 找到了
                    if (character >= '0' && character <= '9') {
                        numString = character + numString;
                    } else {
                        // 找到了非数字
                        stack.push(character);
                        break;
                    }
                }
                Integer num = 0;
                if (numString.length() != 0) {
                    num = Integer.valueOf(numString);
                }else {
                    num = 1;
                }

                for (int i = 0; i < num; i++) {
                        for (int j = characterList.size()-1; j >=0 ; j--) {
                            stack.push(characterList.get(j));
                        }
                    }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeLast());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("2[abc]3[cd[e]]fg"));
    }
}
