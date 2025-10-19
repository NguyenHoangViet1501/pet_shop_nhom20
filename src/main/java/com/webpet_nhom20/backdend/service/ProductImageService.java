package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;

import java.util.List;

public interface ProductImageService {
    public List<ProductImageResponse> createProductImage(List<CreateProductImageRequest> request);
    public ProductImageResponse updateProductImage(int imageId, UpdateProductImageRequest request);
    public String deleteProductImage(int variantId);
}
