package com.codekul.java6AprilSpring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    Employee findByNameAndAddress(String name, String address);

    List<Employee> findByDobBetween(LocalDate firstDate, LocalDate secondDate);

    List<Employee> findByAgeLessThan(Integer age);
    List<Employee> findByAgeGreaterThanEqual(Integer age);
    List<Employee> findByDobAfter(LocalDate dob);
}
