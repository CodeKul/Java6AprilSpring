package com.codekul.java6AprilSpring.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    @JsonBackReference(value = "A")
    private  Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id > 0) {
            this.id = id;
        }else {

        }
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
