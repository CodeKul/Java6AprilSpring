package com.codekul.java6AprilSpring.onetomany.repository;

import com.codekul.java6AprilSpring.onetomany.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp,Long> {
}
