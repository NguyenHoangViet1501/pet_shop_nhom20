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

import java.util.List;

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
    public ProductVariantResponse updateProductVariant(
            int variantId,
            UpdateProductVariantRequest request
    ) {
        //  Lấy variant
        ProductVariants variant = repository.findById(variantId)
                .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));

        //  Update thông tin cơ bản của variant
        mapper.updateProductVariant(variant, request);

        //  Nếu có gửi danh sách imageIds thì mới xử lý ảnh
        if (request.getImageIds() != null) {

            // Danh sách image hiện tại của variant trong DB
            List<ProductVariantImage> currentLinks =
                    productVariantImageRepository.findByVariantId(variantId);

            List<Integer> currentImageIds = currentLinks.stream()
                    .map(pvi -> pvi.getImage().getId())
                    .toList();

            List<Integer> newImageIds = request.getImageIds();

            // 3.1 XÓA những ảnh bị BỎ CHỌN
            List<ProductVariantImage> toDelete = currentLinks.stream()
                    .filter(pvi -> !newImageIds.contains(pvi.getImage().getId()))
                    .toList();

            if (!toDelete.isEmpty()) {
                productVariantImageRepository.deleteAll(toDelete);
            }

            // 3.2 THÊM những ảnh MỚI được CHỌN
            List<Integer> imageIdsToAdd = newImageIds.stream()
                    .filter(id -> !currentImageIds.contains(id))
                    .toList();

            if (!imageIdsToAdd.isEmpty()) {
                List<ProductImages> imagesToAdd =
                        productImageRepository.findAllById(imageIdsToAdd);

                List<ProductVariantImage> newLinks = imagesToAdd.stream()
                        .map(img -> {
                            ProductVariantImage pvi = new ProductVariantImage();
                            pvi.setVariant(variant);
                            pvi.setImage(img);
                            return pvi;
                        })
                        .toList();

                productVariantImageRepository.saveAll(newLinks);
            }
        }

        // Lưu variant
        ProductVariants saved = repository.save(variant);

        // Trả response
        return mapper.toProductVariantResponse(saved);
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
