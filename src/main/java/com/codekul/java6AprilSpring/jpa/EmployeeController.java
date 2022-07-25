package com.codekul.java6AprilSpring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
            employee1.get().setDob(employee.getDob());
            employeeRepo.save(employee1.get());
            return "record updated ..";
        } else {
            return "id not found";
        }
    }

    @DeleteMapping("deleteEmployee")
    public String deleteEmployee(@RequestBody Employee employee) {
        employeeRepo.delete(employee);
        return "employee deleted ..";
    }

    @DeleteMapping("deleteEmployee1/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeRepo.deleteById(id);
        return "employee deleted ..";
    }

    @GetMapping("getById/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        return employeeRepo.getReferenceById(id);
    }

    @GetMapping("getByIdOptional/{id}")
    public Optional<Employee> getEmployeeByIdOptional(@PathVariable("id") Integer id) {
        return employeeRepo.findById(id);
    }

    @GetMapping("getByName/{name}")
    public Employee getEmpByName(@PathVariable("name") String name) {
        return employeeRepo.findByName(name);
    }

    @GetMapping("getByName/{name}/{address}")
    public Employee getEmpByNameAndAddress(@PathVariable("name") String name, @PathVariable("address") String address) {
        return employeeRepo.findByNameAndAddress(name, address);
    }

    @GetMapping("getEmployeeByDate/{firstDate}/{secondDate}")
    public List<Employee> getEmployeeByDate(@PathVariable("firstDate") String firstDate, @PathVariable("secondDate") String secondDate) {
        return employeeRepo.findByDobBetween(LocalDate.parse(firstDate), LocalDate.parse(secondDate));
    }

    @GetMapping("getEmployeeByAge/{age}")
    public List<Employee> getLessThanAge(@PathVariable("age") Integer age) {
        return employeeRepo.findByAgeLessThan(age);
    }

    @GetMapping("getEmployeeByAgeGreater/{age}")
    public List<Employee> getGreaterThanAge(@PathVariable("age") Integer age) {
        return employeeRepo.findByAgeGreaterThanEqual(age);
    }

    @GetMapping("getEmployeeDobAfter/{dob}")
    public List<Employee> getEmployeeDobAfter(@PathVariable("dob") String dob) {
        return employeeRepo.findByDobAfter(LocalDate.parse(dob));
    }


}
