package com.microservices.departmentService.department.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentTO {
    private Integer id;
    private String name;
    private String location;
}
