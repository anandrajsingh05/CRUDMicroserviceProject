package com.microservices.employeeService.employee.dao;

import com.microservices.employeeService.employee.entity.EmployeeBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeBO, Integer> {
}
