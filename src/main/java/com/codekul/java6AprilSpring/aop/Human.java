package com.codekul.java6AprilSpring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Human {

    //advice
//    @Before("point()")
//    public void getUp(){
//        System.out.println("get up");
//    }
//    @After("execution(public void study*())")
//    public void sleep(){
//        System.out.println("sleep");
//    }
//    @Pointcut("execution(public void study*(..))")
//    public void point(){}


    @AfterReturning(value = "execution(public int studyBoy(..))",returning = "value")
    public void afterRet(int value){
        System.out.println("value is =>"+value);
    }

}
