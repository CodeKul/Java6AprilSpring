package com.codekul.java6AprilSpring.composite.controller;

import com.codekul.java6AprilSpring.composite.entity.Gender;
import com.codekul.java6AprilSpring.composite.entity.Prefix;
import com.codekul.java6AprilSpring.composite.entity.PrefixGenderMapping;
import com.codekul.java6AprilSpring.composite.entity.PrefixGenderMappingId;
import com.codekul.java6AprilSpring.composite.repository.GenderRepository;
import com.codekul.java6AprilSpring.composite.repository.PrefixGenderMappingRepository;
import com.codekul.java6AprilSpring.composite.repository.PrefixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrefixGenderController {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private PrefixRepository prefixRepository;

    @Autowired
    private PrefixGenderMappingRepository prefixGenderMappingRepository;

    @PostMapping("saveGender")
    private Gender saveGender(@RequestBody Gender gender){
        return genderRepository.save(gender);
    }

    @PostMapping("savePrefix")
    private String  savePrefix(@RequestBody Prefix prefix){
        Prefix prefix1 =  prefixRepository.save(prefix);

        PrefixGenderMappingId prefixGenderMappingId = new PrefixGenderMappingId();
        prefixGenderMappingId.setGenderId(prefix.getGender());
        prefixGenderMappingId.setPrefixId(prefix1.getId());

        PrefixGenderMapping prefixGenderMapping = new PrefixGenderMapping();
        prefixGenderMapping.setPrefixGenderMappingId(prefixGenderMappingId);

        prefixGenderMappingRepository.save(prefixGenderMapping);
        return "prefix saved";
    }
}
