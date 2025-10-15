package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Product_Variants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<Product_Variants, Integer> {
    List<Product_Variants> findByProductId(int productId);
}
