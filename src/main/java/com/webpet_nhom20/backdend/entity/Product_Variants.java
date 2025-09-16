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
@Table(name = "product_variants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "product_id" , nullable = false)
    int productId;

    @Column(name = "variant_name" , nullable = false)
    String variantName;

    @Column(name = "weight")
    Float weight;

    @Column(name = "price")
    Float price;

    @Column(name = "stock_quantity" , nullable = false)
    int stockQuantity = 0;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "updated_date")
    LocalDate updatedDate;


}
