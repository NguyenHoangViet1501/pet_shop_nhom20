package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Product_Variant.CreateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.request.Product_Variant.UpdateProductVariantRequest;
import com.webpet_nhom20.backdend.dto.response.ProductVariant.ProductVariantResponse;
import com.webpet_nhom20.backdend.entity.ProductImages;
import com.webpet_nhom20.backdend.entity.ProductVariantImage;
import com.webpet_nhom20.backdend.entity.ProductVariants;
import com.webpet_nhom20.backdend.entity.Products;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.ProductVariantMapper;
import com.webpet_nhom20.backdend.repository.ProductImageRepository;
import com.webpet_nhom20.backdend.repository.ProductVariantImageRepository;
import com.webpet_nhom20.backdend.repository.ProductVariantRepository;
import com.webpet_nhom20.backdend.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {
    @Autowired
    private ProductVariantRepository repository;
    @Autowired
    private ProductVariantMapper mapper;
    @Autowired
    private ProductVariantImageRepository productVariantImageRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductVariantResponse createProductVariant(CreateProductVariantRequest request) {

        if(repository.existsByProductIdAndVariantName(request.getProductId(), request.getVariantName())){
            throw new AppException(ErrorCode.VARIANT_NAME_IS_EXISTED);
        }
        Products product = new  Products();
        product.setId(request.getProductId());

        ProductVariants variants = new ProductVariants();
        variants.setVariantName(request.getVariantName());
        variants.setProduct(product);
        variants.setStockQuantity(request.getStockQuantity());
        variants.setPrice(request.getPrice());
        variants.setWeight(request.getWeight());
        variants.setSoldQuantity(0);

        ProductVariants savedVariant = repository.save(variants);

        ProductImages productImages = productImageRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));

        // 5. Tạo và lưu bảng trung gian (ProductVariantImage)
        ProductVariantImage productVariantImage = new ProductVariantImage();
        productVariantImage.setVariant(savedVariant); // Gán đối tượng đã được lưu (có ID)
        productVariantImage.setImage(productImages);

        productVariantImageRepository.save(productVariantImage);

        // 6. Trả về kết quả
        return mapper.toProductVariantResponse(savedVariant);

    }
    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ProductVariantResponse updateProductVariant(int variantId, UpdateProductVariantRequest request) {
        ProductVariants product_variants = repository.findById(variantId).orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));
        ProductVariantImage productVariantImage = new ProductVariantImage();
        ProductImages productImages = productImageRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
        productVariantImage.setVariant(product_variants); // Gán đối tượng đã được lưu (có ID)
        productVariantImage.setImage(productImages);



        productVariantImageRepository.save(productVariantImage);

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
