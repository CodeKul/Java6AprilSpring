package com.codekul.java6AprilSpring.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders =
        {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class PreController {

    @Autowired
    private PrescriptionRepsoitory prescriptionRepsoitory;

    @PostMapping("savePre")
    public String savePrescription(@RequestBody Prescription prescription){
        prescriptionRepsoitory.save(prescription);
        return "presc saved";
    }
}
