package com.week1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWeek1Application {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeek1Application.class, args);
	}

}
