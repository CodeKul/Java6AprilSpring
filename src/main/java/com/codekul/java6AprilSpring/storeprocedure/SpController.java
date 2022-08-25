package com.codekul.java6AprilSpring.storeprocedure;

import com.codekul.java6AprilSpring.onetomany.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SpController {


    @Autowired
    private SPRepository spRepository;

    @GetMapping("getData")
    public List<Map<String,String>> getDate(){
        return spRepository.getVehicle();
    }
}
