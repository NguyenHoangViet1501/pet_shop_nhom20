package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ProductImages;
import com.webpet_nhom20.backdend.entity.ProductVariantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductVariantImageRepository extends JpaRepository<ProductVariantImage, Integer> {

}
