package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @OneToMany(mappedBy = "product")
    private Set<ProductVariants> productVariants;

    @OneToMany(mappedBy = "product")
    private Set<ProductImages> productImages;

    @OneToMany(mappedBy = "product")
    private Set<Reviews> reviews;

    @Column(name = "name" )
    String name;

    @Column(name = "short_description")
    String shortDescription ;

    @Column(name = "description")
    String description ;

    @Column(name = "animal", nullable = true)
    String animal ;

    @Column(name = "brand", nullable = true)
    String brand ;

//    @Column(name = "price" )
//    float price;

    @Column(name = "sold_quantity" , nullable = false)
    int soldQuantity = 0;

    @Column(name = "stock_quantity" ,nullable = false )
    int stockQuantity = 0 ;

    @Column(name = "is_deleted" , length = 1)
    String isDeleted = "0";

    @Column(name = "is_featured" , length = 1)
    String isFeatured = "0";

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
