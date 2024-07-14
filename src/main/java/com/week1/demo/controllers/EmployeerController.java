package com.week1.demo.controllers;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import com.week1.demo.repositories.EmployeeRepository;
import com.week1.demo.services.EmployeeSevice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeerController {
    public EmployeerController(EmployeeSevice employeeSevice) {
        this.employeeSevice = employeeSevice;
    }

    private EmployeeSevice employeeSevice;

    @GetMapping(path = "/")
     public List<EmployeeEntity> getEmployee() {
        System.out.println("api working");
        return  employeeSevice.getEmployee(); // => this controller is handled by EmployeeService and apply database query
    }
    @PostMapping(path = "/create")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployeer) {
        return employeeSevice.createEmployee(inputEmployeer);
    }

    @GetMapping(path = "/employees/{employeesId}")
    public EmployeerDTO getEmployeerById(@PathVariable Long employeesId) {
        return new EmployeerDTO(employeesId,"Dilio kumar romi","eomi.indan@gmail.com",32, LocalDate.of(2024,05,07),true);
    }

}
