package com.dj.aop.boot.demo.boot;

import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @date 2020-09-19 20:38
 */
@Component
public class User {
    public String hello() {
        //System.out.println("hi");
        //throw new RuntimeException();
        return "hi".toString();
    }
}
