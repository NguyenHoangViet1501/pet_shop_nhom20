package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_id" , nullable = false)
    int userId;

    @Column(name = "product_id" , nullable = false)
    int productId;

    @Column(name = "rating" , nullable = false)
    short rating;

    @Column(name = "comment" )
    String comment;

    @Column(name = "is_verified" , length = 1)
    short isVerified = 0;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "updated_date")
    LocalDate updatedDate;

}
