package com.week1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWeek1Application {
	@Autowired
	BeansMethodCreating obj;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeek1Application.class, args);
	}

}
