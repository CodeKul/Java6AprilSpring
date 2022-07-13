package com.codekul.java6AprilSpring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Student {

    @Autowired
    private Subject subject;


    public Student(){
        System.out.println("In constructor");
    }

    public void callSubject(){
        subject.getSubject();
    }


}
