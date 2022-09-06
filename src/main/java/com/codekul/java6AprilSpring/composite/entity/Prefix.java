package com.codekul.java6AprilSpring.composite.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Prefix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;

    @Transient
    private Long gender;
}
