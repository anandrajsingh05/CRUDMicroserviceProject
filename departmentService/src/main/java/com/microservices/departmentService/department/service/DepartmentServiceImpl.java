package com.microservices.departmentService.department.service;

import com.microservices.departmentService.department.dao.DepartmentDao;
import com.microservices.departmentService.department.entity.DepartmentBO;
import com.microservices.departmentService.department.entity.DepartmentTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentDao departmentDao;

    private ModelMapper modelMapper;

    public DepartmentServiceImpl (DepartmentDao departmentDao, ModelMapper modelMapper){
        this.departmentDao = departmentDao;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<DepartmentTO> getAllDepartments() {
        List<DepartmentBO> list = departmentDao.findAll();
        List<DepartmentTO> departmentTOList = new ArrayList<>();
        if(!list.isEmpty()){
            for(DepartmentBO departmentBO : list){
                departmentTOList.add(modelMapper.map(departmentBO, DepartmentTO.class));
            }
        }
        return departmentTOList;
    }

    @Override
    public DepartmentTO getDepartmentById(Integer id) {
        DepartmentBO departmentBO = departmentDao.findById(id).orElse(null);
        if(departmentBO != null){
            return modelMapper.map(departmentBO, DepartmentTO.class);
        }
        return null;
    }

    @Override
    public DepartmentTO getDepartmentByName(String name) {
       DepartmentBO departmentBO = departmentDao.findByNameContaining(name);
       if(departmentBO != null){
           return modelMapper.map(departmentBO, DepartmentTO.class);
       }
       return null;
    }

    @Override
    public DepartmentTO createDepartment(DepartmentTO department) {
        DepartmentBO departmentBO = modelMapper.map(department, DepartmentBO.class);
        return modelMapper.map(departmentDao.save(departmentBO), DepartmentTO.class);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentDao.deleteById(id);
    }
}
