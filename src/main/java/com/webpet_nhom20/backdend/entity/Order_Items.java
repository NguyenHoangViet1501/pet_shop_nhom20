package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order_Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_id")
    int orderId;

    @Column(name = "product_variant_id")
    int productVariantId;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "unit_price")
    Float unitPrice;

    @Column(name = "total_price")
    Float totalPrice;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "updated_date")
    LocalDate updatedDate;

}
