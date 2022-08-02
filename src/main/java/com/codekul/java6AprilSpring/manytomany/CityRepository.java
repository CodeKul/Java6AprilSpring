package com.codekul.java6AprilSpring.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
