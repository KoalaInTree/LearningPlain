package com.djcao.jvm;

/**
 * @author djcao
 * @date 2020-10-21 21:06
 */
public class AAA {

    public void test() {
        BBB bbb = new BBB();
    }

    public class BBB{
        public void test11() {
            test();
        }
    }
}

