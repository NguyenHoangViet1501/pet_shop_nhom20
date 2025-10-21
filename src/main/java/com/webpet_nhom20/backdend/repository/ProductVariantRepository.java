package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariants, Integer> {
    List<ProductVariants> findByProductId(int productId);
    boolean existsByVariantName(String name);
    boolean existsByProductIdAndVariantName(int productId, String variantName);
}
