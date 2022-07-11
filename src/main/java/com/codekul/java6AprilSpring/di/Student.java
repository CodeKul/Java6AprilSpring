package com.codekul.java6AprilSpring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Autowired
    private Subject subject;

    public void callSubject(){
        subject.getSubject();
    }


}
