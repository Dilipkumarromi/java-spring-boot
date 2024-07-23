package com.week1.demo.repositories;

import com.week1.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Product --> name of entity table name, Long -> name of table id name
public interface ProductRespository extends JpaRepository<Product, Long> {
}
