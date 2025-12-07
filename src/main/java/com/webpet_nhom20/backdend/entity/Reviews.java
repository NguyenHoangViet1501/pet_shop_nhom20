package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "rating" , nullable = false)
    short rating;

    @Column(name = "comment" )
    String comment;

    @Column(name = "is_verified" , length = 1)
    short isVerified = 0;

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
