package com.microservices.departmentService.department.controller;

import com.microservices.departmentService.department.entity.DepartmentTO;
import com.microservices.departmentService.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController (DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentTO getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/byName")
    public DepartmentTO getDepartmentByName(@RequestParam("name") String name) {
        return departmentService.getDepartmentByName(name);
    }

    @PostMapping("/add")
    public DepartmentTO createDepartment(@RequestBody DepartmentTO department) {
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}
