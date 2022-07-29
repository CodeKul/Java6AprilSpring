package com.codekul.java6AprilSpring.onetomany.controller;

import com.codekul.java6AprilSpring.onetomany.entity.Emp;
import com.codekul.java6AprilSpring.onetomany.repository.BankRepo;
import com.codekul.java6AprilSpring.onetomany.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private BankRepo bankRepo;

    @PostMapping("saveEmp")
    public String saveEmp(@RequestBody Emp emp) {
        Emp emp1 = empRepo.save(emp);

        emp.getBank().forEach(s -> {
            s.setEmp(emp1);
            s.setIfscCode(s.getIfscCode());
            s.setAccountNumber(s.getAccountNumber());
            bankRepo.save(s);
        });
        return "saved...";
    }
}
