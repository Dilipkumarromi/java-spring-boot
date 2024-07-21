package com.week1.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    --> change column name
    @Column(name = "first_name" ,nullable=false,length = 100)
    private String name;
    private String email;
    private Integer age;
    private LocalDate dataOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
    private String role;
    private Double salary;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
