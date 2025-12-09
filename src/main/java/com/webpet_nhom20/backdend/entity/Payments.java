package com.webpet_nhom20.backdend.entity;


import com.webpet_nhom20.backdend.enums.PaymentMethod;
import com.webpet_nhom20.backdend.enums.PaymentStatus;
import com.webpet_nhom20.backdend.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
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

    @OneToOne
    @JoinColumn(name = "order_id" ,referencedColumnName = "id")
    private Order order;

    @Column(name = "amount" , nullable = false)
    BigDecimal amount;

    @Column(name = "payment_methods" , nullable = false)
    PaymentMethod paymentMethods;

    @Column(name = "status" , nullable = false)
    String status;

    @Column(name = "provider_reference" , nullable = false)
    String providerReference;

    @Column
    PaymentStatus paymentStatus;

    @Column
    PaymentType paymentType;

    @Column(name = "paid_at" , nullable = false)
    LocalDate paidAt;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();

    }

    /**
     * Tự động update ngày khi cập nhật
     */
}
