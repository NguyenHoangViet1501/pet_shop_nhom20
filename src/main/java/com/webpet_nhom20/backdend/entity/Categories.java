package com.webpet_nhom20.backdend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;



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

    @Column(name = "name" )
    String name;

    @Column(name = "description")
    String description ;

    @Column(name = "is_featured" , length = 1)
    String isFeatured = "0";

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "updated_date")
    LocalDate updatedDate;

}
