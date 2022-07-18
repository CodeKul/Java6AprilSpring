package com.codekul.java6AprilSpring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("employee/save")
    public String saveEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "employee saved..";
    }

}
