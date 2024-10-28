package com.microservices.departmentService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfig {

    @Bean
    public ModelMapper getModelMapper(){
       return new ModelMapper();
    }
}
