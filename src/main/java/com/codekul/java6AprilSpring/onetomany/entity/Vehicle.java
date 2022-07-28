package com.codekul.java6AprilSpring.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "A")
    private List<Parts> part;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Parts> getPart() {
        return part;
    }

    public void setPart(List<Parts> part) {
        this.part = part;
    }
}
