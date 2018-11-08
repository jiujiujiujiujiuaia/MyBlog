package com.blog.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.*;




@Aspect
@Slf4j
@Component
public class RedisAspect {
    @Pointcut(value="@annotation(com.blog.core.util.RedisCache)")
    public void pointcut(){

    }

//    @Around("pointcut()")
//    public Object handler(ProceedingJoinPoint joinPoint){
//        Class c = joinPoint.getClass();
//        Object target = joinPoint.getTarget();
//        Signature signature = joinPoint.getSignature();
//        }
}
