package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.response.CategoryResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.mapper.CategoryMapper;
import com.webpet_nhom20.backdend.repository.CategoryRepository;
import com.webpet_nhom20.backdend.service.CategoryService;
import com.webpet_nhom20.backdend.specification.CategorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService

{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getAllCategories(Pageable pageable, String search) {
        Specification<Categories> where = CategorySpecification.buildWhere(search);
        return categoryRepository.findAll(where , pageable).map(categoryMapper::toCategoryResponse);
    }
}
