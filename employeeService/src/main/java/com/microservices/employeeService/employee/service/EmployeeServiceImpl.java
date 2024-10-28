package com.microservices.employeeService.employee.service;

import com.microservices.employeeService.employee.dao.EmployeeDao;
import com.microservices.employeeService.employee.entity.EmployeeBO;
import com.microservices.employeeService.employee.entity.EmployeeTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl (EmployeeDao employeeDao, ModelMapper modelMapper){
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
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
    public EmployeeTO createEmployee(EmployeeTO employee) {
       EmployeeBO employeeBO = modelMapper.map(employee, EmployeeBO.class);
       return modelMapper.map(employeeDao.save(employeeBO), EmployeeTO.class);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.deleteById(id);
    }
}
