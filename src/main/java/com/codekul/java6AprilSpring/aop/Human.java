package com.codekul.java6AprilSpring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Human {

    @Before("execution(public void study*())")
    public void getUp(){
        System.out.println("get up");
    }
}
