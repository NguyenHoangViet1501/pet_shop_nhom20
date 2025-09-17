package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.CategoryResponse;
import com.webpet_nhom20.backdend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping()
    public ApiResponse<Page<CategoryResponse>> getAllCategories(
            Pageable pageable){
        return ApiResponse.<Page<CategoryResponse>>builder().
                success(true).
                result(categoryService.getAllCategories(pageable)).build();
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
