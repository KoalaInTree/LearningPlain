package com.dj.aop.boot.demo.controller;

import com.dj.aop.boot.demo.boot.Log;
import com.dj.aop.boot.demo.boot.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djcao
 * @date 2020-09-19 20:47
 */
@RestController
public class UserController {
    @Autowired
    private User user;

    @GetMapping("hello")
    @Log(pv = true)
    public String hello() {
        return user.hello();
    }
}
