package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "category_id" )
    int categoryId;

    @Column(name = "name" )
    String name;

    @Column(name = "short_description")
    String shortDescription ;

    @Column(name = "description")
    String description ;

    @Column(name = "price" )
    float price;

    @Column(name = "stock_quantity" , nullable = false)
    int stockQuantity = 0;

    @Column(name = "sold_quantity" , nullable = false)
    int soldQuantity = 0;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "is_featured" , length = 1)
    String isFeatured = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "updated_date")
    LocalDate updatedDate;
}
