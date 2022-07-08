package com.codekul.java6AprilSpring.ioc;

import org.springframework.stereotype.Component;

public class Vodafone implements Sim {

    @Override
    public void calling() {
        System.out.println("vodafone calling");
    }

    @Override
    public void data() {
        System.out.println("vodafone data ");

    }
}
