package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public ProductResponse createProduct(CreateProductRequest request) ;

    public ProductResponse updateProduct(int productId , UpdateProductRequest request) ;

    public String deleteProduct(int productId);
    Page<ProductResponse> getAllProduct(Pageable pageable);
}
