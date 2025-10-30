package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ApiResponse<Page<ProductResponse>> getAllProducts(@RequestParam(required = false) String search, @RequestParam(required = false) Integer categoryId,
            Pageable pageable){
        return ApiResponse.<Page<ProductResponse>>builder().
                success(true)
                .message("Lấy danh sách sản phẩm thành công")
                .result(productService.getAllProduct(pageable,categoryId,search)).build();
    }
    @GetMapping("/{productId}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable int productId ){
        ProductResponse response = productService.getProductById(productId );
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .message("")
                .result(response)
                .build();
    }
    @PostMapping
    public ApiResponse<ProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .message("Create product successfully")
                .result(productService.createProduct(request))
                .build();
    }
    @PutMapping("/{productId}")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable int productId, @RequestBody @Valid UpdateProductRequest request){
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .message("Cập nhật sản phẩm thành công!")
                .result(productService.updateProduct(productId,request))
                .build();
    }
    @DeleteMapping("/{productId}")
    public ApiResponse<String> deleteProduct(@PathVariable int productId){
        return ApiResponse.<String>builder()
                .success(true)
                .message(productService.deleteProduct(productId))
                .build();
    }

}
