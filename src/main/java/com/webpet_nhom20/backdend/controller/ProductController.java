package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ApiResponse<Page<ProductResponse>> getAllProducts(
            Pageable pageable){
        return ApiResponse.<Page<ProductResponse>>builder().
                success(true).
                result(productService.getAllProduct(pageable)).build();
    }
}
