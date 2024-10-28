package com.microservices.departmentService.department.dao;

import com.microservices.departmentService.department.entity.DepartmentBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentBO, Integer> {
}
