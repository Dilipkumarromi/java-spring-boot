package com.week1.demo.services;

import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeSevice {
    private  final EmployeeRepository employeeRepository;

    public EmployeeSevice(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity createEmployee(EmployeeEntity inputEmployeer) {
        return employeeRepository.save(inputEmployeer);
    }
    // this is user to direct call by controller
}
