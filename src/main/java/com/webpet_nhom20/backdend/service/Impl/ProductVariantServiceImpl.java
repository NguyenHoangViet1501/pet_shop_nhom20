package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.ProductVariants;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.ProductVariantMapper;
import com.webpet_nhom20.backdend.repository.ProductVariantRepository;
import com.webpet_nhom20.backdend.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {
    @Autowired
    private ProductVariantRepository repository;
    @Autowired
    private ProductVariantMapper mapper;

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductVariantResponse createProductVariant(CreateProductVariantRequest request) {

        if(repository.existsByProductIdAndVariantName(request.getProductId(), request.getVariantName())){
            throw new AppException(ErrorCode.VARIANT_NAME_IS_EXISTED);
        }
        ProductVariants variants = mapper.toProductVariant(request);
        return mapper.toProductVariantResponse(repository.save(variants));

    }
    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductVariantResponse updateProductVariant(int variantId, UpdateProductVariantRequest request) {
        ProductVariants product_variants = repository.findById(variantId).orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));
        mapper.updateProductVariant(product_variants, request);
        return mapper.toProductVariantResponse(repository.save(product_variants));
    }

    @Override
    public String deleteProductVariant(int variantId) {
        ProductVariants product_variants = repository.findById(variantId).orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));
        if(product_variants.getIsDeleted().equals("1")){
            return "Sản phẩm đã bị xóa trước đó";
        }
        product_variants.setIsDeleted("1");
        repository.save(product_variants);
        return "Xóa thành công";
    }
}
