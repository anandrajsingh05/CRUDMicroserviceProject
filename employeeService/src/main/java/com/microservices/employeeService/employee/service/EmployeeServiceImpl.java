package com.microservices.employeeService.employee.service;

import com.microservices.employeeService.employee.dao.EmployeeDao;
import com.microservices.employeeService.employee.dto.DepartmentTO;
import com.microservices.employeeService.employee.entity.EmployeeBO;
import com.microservices.employeeService.employee.entity.EmployeeTO;
import com.microservices.employeeService.employee.httpClients.DepartmentClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    private final ModelMapper modelMapper;

    private final DepartmentClient departmentClient;

    public EmployeeServiceImpl (EmployeeDao employeeDao, ModelMapper modelMapper, DepartmentClient departmentClient){
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
        this.departmentClient = departmentClient;
    }


    @Override
    public List<EmployeeTO> getAllEmployees() {
        List<EmployeeBO> employeeList = employeeDao.findAll();
        List<EmployeeTO> employeeTOList = new ArrayList<>();
        for(EmployeeBO employee : employeeList){
           EmployeeTO employeeTO = modelMapper.map(employee, EmployeeTO.class);
           employeeTOList.add(employeeTO);
        }
        return employeeTOList;
    }

    @Override
    public EmployeeTO getEmployeeById(Integer id) {
       EmployeeBO employeeBO = employeeDao.findById(id).orElse(null);
       return modelMapper.map(employeeBO, EmployeeTO.class);
    }

    @Override
    public EmployeeTO createEmployee(EmployeeTO employee) throws Exception {
       EmployeeBO employeeBO = modelMapper.map(employee, EmployeeBO.class);
       DepartmentTO departmentTO = departmentClient.getDepartmentByName(employee.getDepartmentName());
       if(departmentTO != null){
           employeeBO.setDepartmentId(departmentTO.getId());
           EmployeeTO employeeReturn = modelMapper.map(employeeDao.save(employeeBO), EmployeeTO.class);
           employeeReturn.setDepartmentName(departmentTO.getName());
           return employeeReturn;
       }
       throw new Exception("department Not found");
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.deleteById(id);
    }
}
