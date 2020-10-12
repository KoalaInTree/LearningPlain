package com.dj.aop.boot.demo.boot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @date 2020-10-07 22:05
 */
@Aspect
@Component
public class RTAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.dj.aop.boot.demo.controller.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long time = System.nanoTime();

        Object proceed = proceedingJoinPoint.proceed();

        long now  = System.nanoTime();
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        logger.info(signature.getMethod().getName()+" rt:"+(now - time));

        return proceed;

    }
}
