package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.service.ProductVariantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/variants")
public class ProductVariantController {
    @Autowired
    private ProductVariantService variantService;


    @PostMapping
    public ApiResponse<ProductVariantResponse> createProductVariant(@RequestBody @Valid CreateProductVariantRequest request) {
        return ApiResponse.<ProductVariantResponse>builder()
                .success(true)
                .message("Create variant successfully")
                .result(variantService.createProductVariant(request))
                .build();
    }
    @PutMapping("/{productVariantId}")
    public ApiResponse<ProductVariantResponse> updateProduct(@PathVariable int productVariantId, @RequestBody @Valid UpdateProductVariantRequest request){
        return ApiResponse.<ProductVariantResponse>builder()
                .success(true)
                .message("Cập nhật sản phẩm thành công!")
                .result(variantService.updateProductVariant(productVariantId,request))
                .build();
    }
    @DeleteMapping("/{productVariantId}")
    public ApiResponse<String> deleteProduct(@PathVariable int productVariantId){
        return ApiResponse.<String>builder()
                .success(true)
                .message(variantService.deleteProductVariant(productVariantId))
                .build();
    }
}
