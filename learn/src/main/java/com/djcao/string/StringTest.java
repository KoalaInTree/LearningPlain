package com.djcao.string;

/**
 * @author djcao
 * @date 2020-10-12 22:29
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "3";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("/");
        stringBuilder.append("b");
        stringBuilder.append(a);
        String b = a + "/" + "b" + a;
        System.out.println(stringBuilder);

    }
}
