package com.codekul.java6AprilSpring.storeprocedure;

import com.codekul.java6AprilSpring.di.Student;
import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface SPRepository extends JpaRepository<Vehicle,Long> {

    @Query(value = "{call getVehicleData()}",nativeQuery = true)
    List<Map<String,String>> getVehicle();



}
