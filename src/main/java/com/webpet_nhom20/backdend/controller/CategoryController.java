package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.CategoryResponse;
import com.webpet_nhom20.backdend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping()
    public ApiResponse<Page<CategoryResponse>> getAllCategories(
            Pageable pageable){

        return ApiResponse.<Page<CategoryResponse>>builder().success(true).result(categoryService.getAllCategories(pageable)).build();
    }

}
