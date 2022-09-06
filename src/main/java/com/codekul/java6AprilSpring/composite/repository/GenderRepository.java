package com.codekul.java6AprilSpring.composite.repository;

import com.codekul.java6AprilSpring.composite.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Long> {
}
