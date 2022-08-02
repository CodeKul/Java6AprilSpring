package com.codekul.java6AprilSpring.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PinCodeRepository extends JpaRepository<PinCode,Long> {
}
