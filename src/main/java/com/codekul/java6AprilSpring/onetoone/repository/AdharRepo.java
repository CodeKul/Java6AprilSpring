package com.codekul.java6AprilSpring.onetoone.repository;

import com.codekul.java6AprilSpring.onetoone.entity.AdharDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdharRepo extends JpaRepository<AdharDetails,Long> {
}
