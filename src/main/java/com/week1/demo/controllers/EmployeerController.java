package com.week1.demo.controllers;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class EmployeerController {
    private final EmployeeRepository employeerService;

    public EmployeerController(EmployeeRepository employeerService) {
        this.employeerService = employeerService;
    }


    @GetMapping(path = "/")
     public EmployeeEntity getEmployee() {
        return (EmployeeEntity) employeerService.findAll();
    }
    @GetMapping(path = "/employees/{employeesId}")
    public EmployeerDTO getEmployeerById(@PathVariable Long employeesId) {
        return new EmployeerDTO(employeesId,"Dilio kumar romi","eomi.indan@gmail.com",32, LocalDate.of(2024,05,07),true);
    }

}
