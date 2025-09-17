package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    public Page<CategoryResponse> getAllCategories(Pageable pageable, String search);
}
