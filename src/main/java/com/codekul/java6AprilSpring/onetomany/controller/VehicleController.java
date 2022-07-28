package com.codekul.java6AprilSpring.onetomany.controller;

import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import com.codekul.java6AprilSpring.onetomany.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("saveVehicle")
    public String saveVehicle(@RequestBody Vehicle vehicle) {
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        return "vehicle saved";
    }
}
