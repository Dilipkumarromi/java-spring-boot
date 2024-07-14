package com.week1.demo.repositories;

import com.week1.demo.dto.EmployeerDTO;
import com.week1.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// this model is user to sql query of pre-define as: create,select, and more...
@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity,Long> {

}
