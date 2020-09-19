package com.dj.aop.boot.demo.boot;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author djcao
 * @date 2020-09-19 20:55
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, AtomicLong> map = new ConcurrentHashMap<>();

    @Around(value = "@annotation(Log)")
    public Object pjp(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder stringBuilder = new StringBuilder();
        String requestURI = RequestContextHolder
            .getRequestAttributes() != null ? ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest().getRequestURI() : "";
        stringBuilder.append(
            requestURI);
        stringBuilder.append(": param: ");
        stringBuilder.append(Arrays.toString(pjp.getArgs()));
        Object proceed = pjp.proceed();
        stringBuilder.append(", res: ");
        stringBuilder.append(proceed);
        logger.info(stringBuilder.toString());

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Log annotation = signature.getMethod().getAnnotation(Log.class);
        if (annotation.pv()) {
            AtomicLong atomicLong = map.get(requestURI);
            if (atomicLong == null) {
                atomicLong = new AtomicLong(0);
                map.put(requestURI, atomicLong);
            }
            atomicLong.incrementAndGet();
        }
        return proceed;
    }
}
