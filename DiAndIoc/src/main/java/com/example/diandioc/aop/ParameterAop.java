package com.example.diandioc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {
    @Pointcut("execution(* com.example.diandioc.controller..*.*(..))")
    private void cut(){}
    @Before("cut()")
    public void before(JoinPoint joinPoint){
        System.out.println("-------before-------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("methodName = " + methodName);
        for(Object tmp : args){
            System.out.println("type = " + tmp.getClass().getSimpleName());
            System.out.println("value = " + tmp);
        }
        System.out.println("-------------------");
        System.out.println();
    }
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("-----afterReturning-----");
        System.out.println("returnObj = " + returnObj);
        System.out.println("-------------------");
        System.out.println();
    }
}
