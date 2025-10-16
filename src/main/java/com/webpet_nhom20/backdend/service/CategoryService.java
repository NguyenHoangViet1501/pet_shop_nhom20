package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    public CategoryResponse createCategory(CreateCategoryRequest request) ;

    public CategoryResponse updateCategory(int categoryId , UpdateCategoryRequest request) ;

    public String deleteCategory(int categoryId) ;

    public List<CategoryResponse> getAllCategories();

    public CategoryResponse getCategoryById(int id);


}
