package com.microservices.departmentService.department.service;

import com.microservices.departmentService.department.entity.DepartmentTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentTO> getAllDepartments();

    DepartmentTO getDepartmentById(Integer id);

    DepartmentTO createDepartment(DepartmentTO department);

    void deleteDepartment(Integer id);
}
