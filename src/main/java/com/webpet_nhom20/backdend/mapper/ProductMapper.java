package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ProductMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Mapping(source = "category.name", target = "categoryName")
    public abstract ProductResponse toProductResponse(Products products);

    public abstract List<ProductResponse> toProductResponses(List<Products> products);

    @Mapping(source = "categoryId", target = "category")
    public abstract Products toProduct(CreateProductRequest products);

    @Mapping(source = "categoryId", target = "category")
    public abstract void updateProduct(@MappingTarget Products products, UpdateProductRequest request);

    protected Categories mapCategoryIdToCategory(Integer categoryId) {
        if (categoryId == null) {
            return null;
        }
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Condition
    protected boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
