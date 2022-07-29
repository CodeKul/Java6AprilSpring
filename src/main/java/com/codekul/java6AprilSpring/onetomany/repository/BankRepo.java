package com.codekul.java6AprilSpring.onetomany.repository;

import com.codekul.java6AprilSpring.onetomany.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Long> {
}
