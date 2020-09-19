package com.dj.aop.boot.demo.boot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @date 2020-09-19 20:39
 */
@Aspect
@Component
public class UserAspect {

    @Before("execution(* com.dj.aop.boot.demo.boot.User.*(..))")
    public void before() {
        System.out.println("before");
    }

    @Around("execution(* com.dj.aop.boot.demo.boot.User.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before around");

        Object proceed = pjp.proceed();

        System.out.println("after around");
        return proceed;
    }

    @After("execution(* com.dj.aop.boot.demo.boot.User.*(..))")
    public void after() {
        System.out.println("after");
    }
}
