package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Product.UpdateProductRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;

public interface ProductVariantService {
    public ProductVariantResponse createProductVariant(CreateProductVariantRequest request);
    public ProductVariantResponse updateProductVariant(int variantId, UpdateProductVariantRequest request);
    public String deleteProductVariant(int variantId);
}
