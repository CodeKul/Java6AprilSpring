package com.codekul.java6AprilSpring.onetomany.repository;

import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
