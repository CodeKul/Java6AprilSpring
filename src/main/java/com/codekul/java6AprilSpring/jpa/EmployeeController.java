package com.codekul.java6AprilSpring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("employee/save")
    public String saveEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return "employee saved..";
    }

    @GetMapping("getEmployee")
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @PutMapping("updateEmployee")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return "record updated";
    }

    @PutMapping("updateEmployee1")
    public String updateEmployee1(@RequestBody Employee employee) {
        Optional<Employee> employee1 = employeeRepo.findById(employee.getId());
        if (employee1.isPresent()) {
            employee1.get().setAddress(employee.getAddress());
            employee1.get().setName(employee.getName());
            employeeRepo.save(employee1.get());
            return "record updated ..";
        } else {
            return "id not found";
        }
    }

    @DeleteMapping("deleteEmployee")
    public String deleteEmployee(@RequestBody Employee employee){
        employeeRepo.delete(employee);
        return "employee deleted ..";
    }
    @DeleteMapping("deleteEmployee1/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeRepo.deleteById(id);
        return "employee deleted ..";
    }


}
