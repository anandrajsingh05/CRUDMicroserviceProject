package com.microservices.employeeService.employee.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeTO {
    private Integer id;
    private String name;
    private LocalDate doj;
    private String email;
    private String mobile;
    private Integer age;
    private double salary;
}
