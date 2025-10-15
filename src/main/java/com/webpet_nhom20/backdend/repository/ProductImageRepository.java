package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Product_Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<Product_Images, Integer> {
    List<Product_Images> findByProductId(int productId);
}
