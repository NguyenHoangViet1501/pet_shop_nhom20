package com.webpet_nhom20.backdend.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product_variants")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariantImage> productVariantImages = new ArrayList<>();

    public List<ProductImages> getActualImages() {
        return productVariantImages.stream()
                .map(ProductVariantImage::getImage)
                .toList();
    }

    @OneToMany(mappedBy = "productVariant")
    private Set<CartItems> cartItems;

    @OneToMany(mappedBy = "productVariant")
    private Set<OrderItems> orderItems;

    @Column(name = "variant_name" , nullable = false)
    String variantName;

    @Column(name = "weight")
    Float weight;

    @Column(name = "price")
    Float price;

    @Column(name = "stock_quantity" , nullable = false)
    int stockQuantity = 0;

    @Column(name = "sold_quantity" , nullable = false)
    int soldQuantity = 0;

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
