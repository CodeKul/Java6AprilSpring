package com.codekul.java6AprilSpring.onetoone.controller;

import com.codekul.java6AprilSpring.onetoone.entity.Person;
import com.codekul.java6AprilSpring.onetoone.repository.AdharRepo;
import com.codekul.java6AprilSpring.onetoone.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AdharRepo adharRepo;


    @PostMapping("/savePerson")
    public String savePerson(@RequestBody Person person) {
        personRepo.save(person);
        return "person saved..";
    }
}

/**
 *
 * {
 *     "name": "Akash",
 *     "address": "Pune",
 *     "adharDetails": {
 *         "adharNumber": 42702049732
 *     }
 * }
 */