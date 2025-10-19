package com.webpet_nhom20.backdend.mapper;


import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.Products;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductResponse toProductResponse(Products products);
    List<ProductResponse> toProductResponses(List<Products> products);
    Products toProduct(CreateProductRequest products);
    void updateProduct(@MappingTarget Products products, UpdateProductRequest request);


    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
