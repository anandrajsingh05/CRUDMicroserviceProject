package com.microservices.employeeService.employee.service;

import com.microservices.employeeService.employee.entity.EmployeeTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeTO> getAllEmployees();

    EmployeeTO getEmployeeById(Integer id);

    EmployeeTO createEmployee(EmployeeTO employee);

    void deleteEmployee(Integer id);
}
