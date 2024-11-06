package com.microservices.employeeService.employee.httpClients;

import com.microservices.employeeService.employee.dto.DepartmentTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping(value = "/department/byName")
    DepartmentTO getDepartmentByName(@RequestParam("name") String name);


}
