package com.week1.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        // table name
        name="tbl_product",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
                @UniqueConstraint(name = "title_price_unique", columnNames = {"title_x", "price"})
        },
        indexes = {
                @Index(name="sku_index",columnList = "sku")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String sku;
    private String title;
    private double price;
    private Integer quantity ;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
