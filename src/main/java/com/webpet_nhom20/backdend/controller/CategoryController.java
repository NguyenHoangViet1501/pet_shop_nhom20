package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Create category successfully")
                .result(categoryService.createCategory(request))
                .build();
    }


    @GetMapping()
    public ApiResponse<List<CategoryResponse>> getAllCategories(
            ){
        return ApiResponse.<List<CategoryResponse>>builder().
                success(true).
                result(categoryService.getAllCategories()).build();
    }

    @GetMapping("/{categoryId}")
    ApiResponse<CategoryResponse> getCategoryById(Pageable pageable, @PathVariable int categoryId ){
        CategoryResponse response = categoryService.getCategoryById(pageable,categoryId );
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .result(response)
                .build();
    }


}
