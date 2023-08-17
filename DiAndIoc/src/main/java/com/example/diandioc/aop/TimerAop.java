package com.example.diandioc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.diandioc.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.diandioc.annotation.Timer)")
    private void enableTimer(){}
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Object result =  joinPoint.proceed();
            stopWatch.stop();
            double totalTime = stopWatch.getTotalTimeSeconds();
            System.out.println("totalTime = " + totalTime);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
