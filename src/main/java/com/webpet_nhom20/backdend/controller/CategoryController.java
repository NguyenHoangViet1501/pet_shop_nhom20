package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ApiResponse<Page<CategoryResponse>> getAllCategories( String search , Pageable pageable
            ){
        return ApiResponse.<Page<CategoryResponse>>builder().
                success(true).
                result(categoryService.getAllCategories(search ,pageable)).build();
    }
    @PostMapping("/feature")
    public ApiResponse<Page<CategoryResponse>> filterByFeature(@RequestParam("isFeature") String isFeature,  Pageable pageable){
        return ApiResponse.<Page<CategoryResponse>>builder().
                success(true)
                .message("Lấy danh sách Categories feature thành công")
                .result(categoryService.filterByFeature(isFeature,pageable))
                .build();
    }
    @PostMapping("/delete")
    public ApiResponse<Page<CategoryResponse>> filterByDelete(@RequestParam("isDelete") String isDelete,  Pageable pageable){
        return ApiResponse.<Page<CategoryResponse>>builder().
                success(true)
                .message("Lấy danh sách Categories delete thành công")
                .result(categoryService.filterByDelete(isDelete,pageable))
                .build();
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
