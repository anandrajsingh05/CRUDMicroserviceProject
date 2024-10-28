package com.microservices.employeeService.employee.controller;

import com.microservices.employeeService.employee.entity.EmployeeTO;
import com.microservices.employeeService.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<EmployeeTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeTO getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(value = "/add")
    public EmployeeTO createEmployee(@RequestBody EmployeeTO employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
