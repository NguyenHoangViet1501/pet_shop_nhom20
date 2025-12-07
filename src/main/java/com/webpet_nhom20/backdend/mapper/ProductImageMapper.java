package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.entity.ProductImages;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.repository.ProductRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ProductImageMapper {

    @Autowired
    private ProductRepository productRepository;

    public abstract ProductImageResponse toProductImageResponse(ProductImages productImages);

    @Mapping(source = "productId", target = "product")
    public abstract ProductImages toProductImage(CreateProductImageRequest request);

    public abstract void updateProductImage(@MappingTarget ProductImages productImages, UpdateProductImageRequest request);

    protected Products mapProductIdToProduct(Integer productId) {
        if (productId == null) {
            return null;
        }
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Condition
    protected boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
