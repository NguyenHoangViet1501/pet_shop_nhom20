package com.webpet_nhom20.backdend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name" , nullable = false)
    String name;

    @Column(name = "description")
    String description ;

    @OneToMany(mappedBy = "category")
    private Set<Products> products;

    @Column(name = "is_featured" , length = 1)
    String isFeatured = "0";

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    Date createdDate;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    Date updatedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        updatedDate = new Date();
    }

    /**
     * Tự động update ngày khi cập nhật
     */
    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

}
