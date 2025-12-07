package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    Categories toCategory(CreateCategoryRequest request);

    @Mapping(target = "products", ignore = true)
    CategoryResponse toCategoryResponse(Categories categories);

    void updateCategory(@MappingTarget Categories categories, UpdateCategoryRequest request);

    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
