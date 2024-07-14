package com.week1.demo.controllers;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.repositories.EmployeeRepository;
import com.week1.demo.services.EmployeeSevice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeerController {
    private final EmployeeRepository employeeRepository;
    private final EmployeeSevice employeeSevice;

    public EmployeerController(EmployeeSevice employeeSevice, EmployeeRepository employeeRepository) {
        this.employeeSevice = employeeSevice;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/")
     public List<EmployeerDTO> getEmployee() {
        System.out.println("api working");
        return  employeeSevice.getEmployee(); // => this controller is handled by EmployeeService and apply database query
    }
    @PostMapping(path = "/create")
    public EmployeerDTO createEmployee(@RequestBody EmployeerDTO inputEmployeer) {
        return employeeSevice.createEmployee(inputEmployeer);
    }

    @PutMapping(path = "/{id}")
    public EmployeerDTO updateEmployeeById(@RequestBody EmployeerDTO employeerDTO,@PathVariable Long id) {
        return employeeSevice.updateEmployeeById(id,employeerDTO);
    }
    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        System.out.println("api working"+id);
        return employeeSevice.deleteEmployeeById(id);
    }

    @PatchMapping(path = "/update/{id}")
    public EmployeerDTO updatePatchEmployeeById(@RequestBody Map<String,Object> update, @PathVariable Long id) {
        return employeeSevice.updatePatchEmployeeById(id,update);
    }
}
