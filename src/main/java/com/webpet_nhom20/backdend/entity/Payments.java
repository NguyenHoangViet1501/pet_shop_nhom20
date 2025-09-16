package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_id" , nullable = false)
    int orderId;

    @Column(name = "amount" , nullable = false)
    Float amount;

    @Column(name = "payment_methods" , nullable = false)
    String paymentMethods;

    @Column(name = "status" , nullable = false)
    String status;

    @Column(name = "provider_reference" , nullable = false)
    String providerReference;

    @Column(name = "paid_at" , nullable = false)
    LocalDate paidAt;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

}
