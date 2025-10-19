package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductResponse> getAllProduct(Pageable pageable);
}
