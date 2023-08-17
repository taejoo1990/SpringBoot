package com.example.diandioc.aop;

import com.example.diandioc.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.diandioc.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.example.diandioc.annotation.Decode)")
    private void enableDecode() {
    }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                try {
                    User user = User.class.cast(arg);
                    String base64Email = user.getEmail();
                    //String email = Base64.getDecoder().decode(base64Email).toString();
                    String email = null;
                    email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                    user.setEmail(email);
                    System.out.println("before Decode mail = "+user.getEmail());
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof User){
            try{
                User user = User.class.cast(returnObj);
                String email = user.getEmail();
                String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
                user.setEmail(base64Email);
                System.out.println("after Decode mail = "+user.getEmail());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
