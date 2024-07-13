package com.week1.demo.repositories;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository  extends JpaRepository<EmployeeEntity,Long> {

}
