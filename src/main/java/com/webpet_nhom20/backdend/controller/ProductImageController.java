package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.service.ProductImageService;
import com.webpet_nhom20.backdend.service.ProductImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ProductImageController {
    @Autowired
    private ProductImageService imageService;


    @PostMapping
    public ApiResponse<List<ProductImageResponse>> createProductImage(@RequestBody @Valid List<CreateProductImageRequest> request) {
        List<ProductImageResponse> responses = imageService.createProductImage(request);
        return ApiResponse.<List<ProductImageResponse>>builder()
                .success(true)
                .message("Create image successfully")
                .result(responses)
                .build();
    }
    @PutMapping("/{productImageId}")
    public ApiResponse<ProductImageResponse> updateProductImage(@PathVariable int productImageId, @RequestBody @Valid UpdateProductImageRequest request){
        return ApiResponse.<ProductImageResponse>builder()
                .success(true)
                .message("Cập nhật sản phẩm thành công!")
                .result(imageService.updateProductImage(productImageId,request))
                .build();
    }
    @DeleteMapping("/{productImageId}")
    public ApiResponse<String> deleteProduct(@PathVariable int productImageId){
        return ApiResponse.<String>builder()
                .success(true)
                .message(imageService.deleteProductImage(productImageId))
                .build();
    }
}
