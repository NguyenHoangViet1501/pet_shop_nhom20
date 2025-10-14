package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponse> getAllCategories();

    public CategoryResponse getCategoryById(Pageable pageable ,int id);


}
