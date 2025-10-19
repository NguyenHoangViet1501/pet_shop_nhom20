package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.Product_Images;
import com.webpet_nhom20.backdend.entity.Product_Variants;
import com.webpet_nhom20.backdend.entity.Products;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductImageMapper {
    ProductImageResponse toProductImageResponse(Product_Images productImages);
    Product_Images toProductImage(CreateProductImageRequest request);
    void updateProductImage(@MappingTarget Product_Images productImages, UpdateProductImageRequest request);


    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
