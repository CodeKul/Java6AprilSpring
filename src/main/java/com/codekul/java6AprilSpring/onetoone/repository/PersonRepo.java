package com.codekul.java6AprilSpring.onetoone.repository;

import com.codekul.java6AprilSpring.onetoone.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
}
