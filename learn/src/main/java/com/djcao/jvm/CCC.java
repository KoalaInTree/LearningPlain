package com.djcao.jvm;

import com.djcao.jvm.AAA.BBB;

/**
 * @author djcao
 * @date 2020-10-21 21:10
 */
public class CCC {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        BBB bbb = aaa.new BBB();
    }
}
