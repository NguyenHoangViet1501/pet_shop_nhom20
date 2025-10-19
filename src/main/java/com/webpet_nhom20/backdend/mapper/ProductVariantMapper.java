package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.Product_Variants;
import com.webpet_nhom20.backdend.entity.Products;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductVariantMapper {
    ProductVariantResponse toProductVariantResponse(Product_Variants product_variants);
    Product_Variants toProductVariant(CreateProductVariantRequest product_variants);
    void updateProductVariant(@MappingTarget Product_Variants product_variants, UpdateProductVariantRequest request);


    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
