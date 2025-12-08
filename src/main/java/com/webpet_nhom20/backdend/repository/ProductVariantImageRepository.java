package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ProductVariantImage;
import com.webpet_nhom20.backdend.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductVariantImageRepository extends JpaRepository<ProductVariantImage, Integer> {
    @Query(value = "SELECT i.image_url FROM product_images i" +
            "            JOIN product_variant_image imv ON i.id = imv.image_id " +
            "            WHERE imv.variant_id = :variantId",
            nativeQuery = true)
    List<String> getImageUrlByVariantId(@Param("variantId") int variantId);
}
