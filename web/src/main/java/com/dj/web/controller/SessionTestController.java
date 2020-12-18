package com.dj.web.controller;

import com.dj.web.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionTestController {
    public static final String KEY = "DDDD";

    public static final String LOGIN_PREFIX = "LEAN_LOGIN_PREFIX";

    @RequestMapping("session/add")
    public String add(HttpSession session) {
        String attribute = (String)session.getAttribute(KEY);
        if(attribute == null){
            attribute = "0";
        }
        attribute = (Integer.parseInt(attribute) + 1) + "";
        session.setAttribute(KEY,attribute);
        return attribute;
    }

    @RequestMapping("login")
    public String login(HttpSession session, @RequestParam Long userId) {
        if (!true) {
            //登录账号密码错误,给前端响应
        }
        User user = new User();
        user.setId(userId);
        session.setAttribute(LOGIN_PREFIX,user);
        return "ok";
    }

    @RequestMapping("loginPage")
    public String login() {
        return "loginPage";
    }
}
