package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Product_Image.CreateProductImageRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Image.UpdateProductImageRequest;
import com.webpet_nhom20.backdend.dto.response.ProductImage.ProductImageResponse;
import com.webpet_nhom20.backdend.entity.Product_Images;
import com.webpet_nhom20.backdend.entity.Product_Variants;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.ProductImageMapper;
import com.webpet_nhom20.backdend.repository.ProductImageRepository;
import com.webpet_nhom20.backdend.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository repository;
    @Autowired
    private ProductImageMapper mapper;

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public List<ProductImageResponse> createProductImage(List<CreateProductImageRequest> requests) {
        int position = 0;
        List<ProductImageResponse> responses = new ArrayList<>();

        for (CreateProductImageRequest req : requests) {
            Product_Images image = new Product_Images();
            image.setProductId(req.getProductId());
            image.setImageUrl(req.getImageUrl());
            image.setPosition(position++);
            image.setIsPrimary(req.getIsPrimary());

            Product_Images saved = repository.save(image);
            responses.add(mapper.toProductImageResponse(saved));
        }

        return responses;
    }

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductImageResponse updateProductImage(int ImageId, UpdateProductImageRequest request) {
        Product_Images product_images = repository.findById(ImageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
        mapper.updateProductImage(product_images, request);
        return mapper.toProductImageResponse(repository.save(product_images));
    }

    @Override
    public String deleteProductImage(int imageId) {
        Product_Images product_images = repository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
        if(product_images.getIsDeleted().equals("1")){
            return "Sản phẩm đã bị xóa trước đó";
        }
        product_images.setIsDeleted("1");
        repository.save(product_images);
        return "Xóa thành công";
    }
}
