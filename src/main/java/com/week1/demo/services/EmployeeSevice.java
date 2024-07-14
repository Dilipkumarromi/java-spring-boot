package com.week1.demo.services;
import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeSevice {

    private  final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeSevice(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeerDTO> getEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity ->modelMapper.map(employeeEntity,EmployeerDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeerDTO createEmployee(EmployeerDTO inputEmployeer) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployeer, EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeerDTO.class);
    }
    // this is user to direct call by controller
}
