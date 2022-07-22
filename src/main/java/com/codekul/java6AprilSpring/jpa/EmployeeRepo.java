package com.codekul.java6AprilSpring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    Employee findByNameAndAddress(String name, String address);

    Employee findByDobBetween(LocalDate firstDate,LocalDate secondDate);
}
