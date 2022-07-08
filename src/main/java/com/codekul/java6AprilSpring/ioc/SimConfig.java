package com.codekul.java6AprilSpring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimConfig {

    @Bean
    public Vodafone getVodafone(){
        return new Vodafone();
    }

    @Bean
    public Jio getJio(){
        return new Jio();
    }

}
