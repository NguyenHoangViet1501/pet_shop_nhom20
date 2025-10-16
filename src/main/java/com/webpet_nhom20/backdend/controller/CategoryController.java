package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Create category successfully")
                .result(categoryService.createCategory(request))
                .build();
    }

    @PutMapping("/{categoryId}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable int categoryId, @RequestBody @Valid UpdateCategoryRequest request){
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Cập nhật category thành công!")
                .result(categoryService.updateCategory(categoryId,request))
                .build();
    }

    @DeleteMapping("/{categoryId}")
    public ApiResponse<String> deleteCategory(@PathVariable int categoryId){
        return ApiResponse.<String>builder()
                .success(true)
                .message(categoryService.deleteCategory(categoryId))
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
    ApiResponse<CategoryResponse> getCategoryById(@PathVariable int categoryId ){
        CategoryResponse response = categoryService.getCategoryById(categoryId );
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .result(response)
                .build();
    }


}
