package com.dj.web.interceptor;

import com.dj.web.controller.SessionTestController;
import com.dj.web.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute(SessionTestController.LOGIN_PREFIX);
        if (user == null){
            response.sendRedirect("/loginPage");
            return false;
        }
        return true;
    }
}
