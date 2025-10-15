package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.Product_Images;
import com.webpet_nhom20.backdend.entity.Product_Variants;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.repository.ProductImageRepository;
import com.webpet_nhom20.backdend.repository.ProductRepository;
import com.webpet_nhom20.backdend.repository.ProductVariantRepository;
import com.webpet_nhom20.backdend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Override
    public Page<ProductResponse> getAllProduct(Pageable pageable) {
        Page<Products> productPage = productRepository.findAll(pageable);
        List<ProductResponse> productResponses = productPage.getContent().stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(productResponses, pageable, productPage.getTotalElements());
    }

    private ProductResponse mapToProductResponse(Products product) {
        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .name(product.getName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .price(String.valueOf(product.getPrice()))
                .stockQuantity(String.valueOf(product.getStockQuantity()))
                .soldQuantity(String.valueOf(product.getSoldQuantity()))
                .isDeleted(product.getIsDeleted())
                .isFeatured(product.getIsFeatured())
                .createdDate(String.valueOf(product.getCreatedDate()))
                .updatedDate(String.valueOf(product.getUpdatedDate()))
                .build();

        List<Product_Images> images = productImageRepository.findByProductId(product.getId());
        List<ProductImageResponse> imageResponses = images.stream()
                .map(image -> ProductImageResponse.builder()
                        .id(image.getId())
                        .productId(image.getProductId())
                        .imageUrl(image.getImageUrl())
                        .position(image.getPosition())
                        .isPrimary(image.getIsPrimary())
                        .isDeleted(image.getIsDeleted())
                        .createdDate(image.getCreatedDate())
                        .updatedDate(image.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        response.setProductImage(imageResponses);

        List<Product_Variants> variants = productVariantRepository.findByProductId(product.getId());
        List<ProductVariantResponse> variantResponses = variants.stream()
                .map(variant -> ProductVariantResponse.builder()
                        .id(variant.getId())
                        .productId(variant.getProductId())
                        .variantName(variant.getVariantName())
                        .weight(variant.getWeight())
                        .price(variant.getPrice())
                        .stockQuantity(variant.getStockQuantity())
                        .isDeleted(variant.getIsDeleted())
                        .createdDate(variant.getCreatedDate())
                        .updatedDate(variant.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        response.setProductVariant(variantResponses);

        return response;
    }
}
