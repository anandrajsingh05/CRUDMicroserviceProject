package com.microservices.employeeService.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentTO {
    private Integer id;
    private String name;
    private String location;
}
