package com.microservices.employeeService.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer departmentId;

    @Column(nullable = false, length = 256)
    private String name;

    private LocalDate doj;

    @Column(nullable = false, length = 256)
    private String email;

    @Column(nullable = false, length = 15)
    private String mobile;

    @Column(nullable = false)
    private Integer age;

    private String designation;

    private double salary;

}
