package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductImageService {
    public List<ProductImageResponse> createProductImage(List<CreateProductImageRequest> request);

    @PreAuthorize("hasRole('SHOP')")
    List<ProductImageResponse> uploadProductImages(int productId, MultipartFile[] files, int[] positions);

    public ProductImageResponse updateProductImage(int imageId, UpdateProductImageRequest request);
    public String deleteProductImage(int variantId);
}
