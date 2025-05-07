package com.example.korea_sleepTech_springboot.시험.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @PrePersist
    private void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}
