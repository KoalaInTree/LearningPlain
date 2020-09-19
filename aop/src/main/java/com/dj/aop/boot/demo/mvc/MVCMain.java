package com.dj.aop.boot.demo.mvc;

import com.dj.aop.boot.demo.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author djcao
 * @date 2020-09-19 21:20
 */
public class MVCMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "classpath:applicationContext.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        bean.hello();
    }
}
