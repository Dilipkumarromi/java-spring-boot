package com.week1.demo.controllers;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeerController {
    private final EmployeeRepository employeerService;

    public EmployeerController(EmployeeRepository employeerService) {
        this.employeerService = employeerService;
    }


    @GetMapping(path = "/")
     public List<EmployeeEntity> getEmployee() {
        System.out.println("api working");
        return  employeerService.findAll();
    }
    @PostMapping(path = "/create")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployeer) {
        return employeerService.save(inputEmployeer);
    }

    @GetMapping(path = "/employees/{employeesId}")
    public EmployeerDTO getEmployeerById(@PathVariable Long employeesId) {
        return new EmployeerDTO(employeesId,"Dilio kumar romi","eomi.indan@gmail.com",32, LocalDate.of(2024,05,07),true);
    }

}
