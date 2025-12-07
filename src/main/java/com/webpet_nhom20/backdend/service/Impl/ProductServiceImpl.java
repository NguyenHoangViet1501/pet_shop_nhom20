package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Product.CreateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.ProductImages;
import com.webpet_nhom20.backdend.entity.ProductVariants;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.ProductMapper;
import com.webpet_nhom20.backdend.repository.CategoryRepository;
import com.webpet_nhom20.backdend.repository.ProductImageRepository;
import com.webpet_nhom20.backdend.repository.ProductRepository;
import com.webpet_nhom20.backdend.repository.ProductVariantRepository;
import com.webpet_nhom20.backdend.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryRepository categoryRepository;



    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        if(productRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.PRODUCT_IS_EXISTED);
        }
        if(categoryRepository.findById(request.getCategoryId()).isEmpty()){
            throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
        }
        Products products = productMapper.toProduct(request);
        return productMapper.toProductResponse(productRepository.save(products));
    }

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductResponse updateProduct(int productId, UpdateProductRequest request) {
        Products products = productRepository.findById(productId).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productMapper.updateProduct(products, request);
        return productMapper.toProductResponse(productRepository.save(products));
    }

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public String deleteProduct(int productId) {
        Products products = productRepository.findById(productId).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        if(products.getIsDeleted().equals("1")){
            return "Sản phẩm đã bị xóa trước đó";
        }
        products.setIsDeleted("1");
        productRepository.save(products);
        return "Xóa thành công";
    }

    @Override
    @Cacheable(value = "product_list", key = "{#pageable.pageNumber, #pageable.pageSize, #search, #categoryId, #minPrice, #maxPrice}")
    public Page<ProductResponse> getAllProduct(Pageable pageable, Integer categoryId, String search, Double minPrice, Double maxPrice) {
        Page<Products> productPage;

        // 1. Chuẩn hóa điều kiện lọc
        boolean hasCategory = categoryId != null && categoryId > 0;
        boolean hasSearch = search != null && !search.trim().isEmpty();

        // Kiểm tra có lọc giá hay không (chỉ cần nhập min HOẶC max là tính có lọc)
        boolean hasPrice = minPrice != null || maxPrice != null;

        // Tự động điền giá trị thiếu:
        // - Nếu thiếu min -> coi như min = 0
        // - Nếu thiếu max -> coi như max = số cực lớn
        Double finalMin = (minPrice != null) ? minPrice : 0.0;
        Double finalMax = (maxPrice != null) ? maxPrice : Double.MAX_VALUE;

        // 2. Xử lý phân nhánh if-else
        if (hasPrice) {
            // === NHÓM CÓ LỌC GIÁ ===
            if (hasCategory && hasSearch) {
                // Case 1: Category + Search + Price
                productPage = productRepository.findByCategoryIdAndNameContainingIgnoreCaseAndPriceBetween(
                        categoryId, search.trim(), finalMin, finalMax, pageable);
            } else if (hasCategory) {
                // Case 2: Category + Price
                productPage = productRepository.findByCategoryIdAndPriceBetween(
                        categoryId, finalMin, finalMax, pageable);
            } else if (hasSearch) {
                // Case 3: Search + Price
                productPage = productRepository.findByNameContainingIgnoreCaseAndPriceBetween(
                        search.trim(), finalMin, finalMax, pageable);
            } else {
                // Case 4: Chỉ lọc theo Price
                productPage = productRepository.findByPriceBetween(
                        finalMin, finalMax, pageable);
            }
        } else {
            // === NHÓM KHÔNG LỌC GIÁ (Logic cũ) ===
            if (hasCategory && hasSearch) {
                // Case 5: Category + Search
                productPage = productRepository.findByCategoryIdAndNameContainingIgnoreCase(categoryId, search.trim(), pageable);
            } else if (hasCategory) {
                // Case 6: Chỉ Category
                productPage = productRepository.findByCategoryId(
                        categoryId, pageable);
            } else if (hasSearch) {
                // Case 7: Chỉ Search
                productPage = productRepository.findByNameContainingIgnoreCase(
                        search.trim(), pageable);
            } else {
                // Case 8: Không lọc gì cả (Lấy tất cả)
                productPage = productRepository.findAll(pageable);
            }
        }

        // 3. Map dữ liệu sang Response
        List<ProductResponse> productResponses = productPage.getContent().stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(productResponses, pageable, productPage.getTotalElements());
    }

    @Override
    public ProductResponse getProductById(int productId){
        Products product = productRepository.findById(productId).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        return mapToProductResponse(product);
    }



    private ProductResponse mapToProductResponse(Products product) {
        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .name(product.getName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .soldQuantity(String.valueOf(product.getSoldQuantity()))
                .stockQuantity(String.valueOf(product.getStockQuantity()))
                .isDeleted(product.getIsDeleted())
                .isFeatured(product.getIsFeatured())
                .createdDate(product.getCreatedDate())
                .updatedDate(product.getUpdatedDate())
                .build();

        List<ProductImages> images = productImageRepository.findByProductId(product.getId());
        List<ProductImageResponse> imageResponses = images.stream()
                .map(image -> ProductImageResponse.builder()
                        .id(image.getId())
                        .productId(image.getProduct().getId())
                        .imageUrl(image.getImageUrl())
                        .position(image.getPosition())
                        .isPrimary(image.getIsPrimary())
                        .isDeleted(image.getIsDeleted())
                        .createdDate(image.getCreatedDate())
                        .updatedDate(image.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        response.setProductImage(imageResponses);

        List<ProductVariants> variants = productVariantRepository.findByProductId(product.getId());
        List<ProductVariantResponse> variantResponses = variants.stream()
                .map(variant -> ProductVariantResponse.builder()
                        .id(variant.getId())
                        .productId(variant.getProduct().getId())
                        .productImageId(variant.getProductVariantImages().isEmpty()
                                ? null
                                : variant.getProductVariantImages().get(0).getImage().getId())
                        .variantName(variant.getVariantName())
                        .weight(variant.getWeight())
                        .price(variant.getPrice())
                        .stockQuantity(variant.getStockQuantity())
                        .soldQuantity(variant.getSoldQuantity())
                        .isDeleted(variant.getIsDeleted())
                        .createdDate(variant.getCreatedDate())
                        .updatedDate(variant.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        response.setProductVariant(variantResponses);

        return response;
    }
}
