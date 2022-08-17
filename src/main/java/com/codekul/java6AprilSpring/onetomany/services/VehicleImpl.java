package com.codekul.java6AprilSpring.onetomany.services;

import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import com.codekul.java6AprilSpring.onetomany.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public String saveVehicle(Vehicle vehicle) {
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        return "vehicle saved";
    }
}
