package com.webpet_nhom20.backdend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServicesPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    String name;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT", unique = true)
    String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    String description;

    @Column(name = "duration_minutes", nullable = false)
    Integer durationMinutes = 30;

    @Column(precision = 12, scale = 2)
    BigDecimal price = BigDecimal.ZERO;

    @Column(name = "is_active", length = 1)
    String isActive;

    @Column(name = "create_date", length = 19, updatable = false)
    LocalDateTime createDate;

    @Column(name = "update_date", length = 19)
    LocalDateTime updateDate;

    @PrePersist
    protected void onCreate(){
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
