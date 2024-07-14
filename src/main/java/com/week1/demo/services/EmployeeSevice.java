package com.week1.demo.services;
import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

    public EmployeerDTO updateEmployeeById(Long id, EmployeerDTO employeerDTO) {
        EmployeeEntity employeeEntity=modelMapper.map(employeerDTO,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeerDTO.class);
    }
    public boolean isExistingEmployeeById(Long id) {
        return employeeRepository.existsById(id);
    }
    public boolean deleteEmployeeById(Long id) {
        System.out.println("deleteEmployeeById"+id);
        boolean exists=employeeRepository.existsById(id);
        if(!exists) return false;
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeerDTO updatePatchEmployeeById(Long id, Map<String, Object> update) {
        boolean exists=isExistingEmployeeById(id);
        if(!exists) return null;
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        update.forEach((field,value)->{
         Field fieldToBeUpdate = org.springframework.data.util.ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
         fieldToBeUpdate.setAccessible(true);
         ReflectionUtils.setField(fieldToBeUpdate,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeerDTO.class);
    }


    // this is user to direct call by controller
}
