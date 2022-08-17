package com.codekul.java6AprilSpring.onetomany.controller;

import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import com.codekul.java6AprilSpring.onetomany.repository.VehicleRepository;
import com.codekul.java6AprilSpring.onetomany.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("saveVehicle")
    public String saveVehicle(@RequestBody Vehicle vehicle) {
      return vehicleService.saveVehicle(vehicle);
    }
}
