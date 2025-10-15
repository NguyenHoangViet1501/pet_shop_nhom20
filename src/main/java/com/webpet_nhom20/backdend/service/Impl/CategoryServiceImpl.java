package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.CategoryMapper;
import com.webpet_nhom20.backdend.mapper.ProductMapper;
import com.webpet_nhom20.backdend.repository.CategoryRepository;
import com.webpet_nhom20.backdend.repository.ProductRepository;
import com.webpet_nhom20.backdend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService

{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper  productMapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        if(categoryRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.CATEGORY_IS_EXISTED);
        }
         Categories categories = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(categories));
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).toList();
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        Categories category = categoryRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        CategoryResponse response = categoryMapper.toCategoryResponse(category);
        List<Products> productList = productRepository.findAllByCategoryId(category.getId());

        List<ProductResponse> productResponseList = productList.stream().map(productMapper::toProductResponse).toList();
        response.setProducts(productResponseList);
        return response;
    }
}
