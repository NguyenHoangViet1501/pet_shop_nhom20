package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductVariantRequest {

    /**
     * ID sản phẩm
     * - Không được để trống
     * - Phải là số dương
     */
    @NotNull(message = "PRODUCT_ID_NOT_NULL")
    @Positive(message = "PRODUCT_ID_MUST_BE_POSITIVE")
    int productId;

    /**
     * ID hình ảnh sản phẩm
     * - Không được để trống
     * - Phải là số dương
     */
    @NotNull(message = "PRODUCT_IMAGE_ID_NOT_NULL")
    @Positive(message = "PRODUCT_IMAGE_ID_MUST_BE_POSITIVE")
    int productImageId;

    /**
     * Tên biến thể
     * - Không được để trống
     * - Từ 1-255 ký tự
     * 
     * Ví dụ: 500g, 1kg, Màu đỏ, Size M
     */
    @NotBlank(message = "VARIANT_NAME_NOT_BLANK")
    @Size(min = 1, max = 255, message = "VARIANT_NAME_SIZE_INVALID")
    String variantName;

    /**
     * Khối lượng (gram)
     * - Phải là số dương nếu được cung cấp
     */
    @Positive(message = "WEIGHT_MUST_BE_POSITIVE")
    Float weight;

    /**
     * Giá của biến thể
     * - Không được để trống
     * - Phải là số dương hoặc bằng 0
     */
    @NotNull(message = "VARIANT_PRICE_IS_NOT_NULL")
    @PositiveOrZero(message = "VARIANT_PRICE_MUST_BE_POSITIVE_OR_ZERO")
    Float price;
    
    /**
     * Số lượng tồn kho
     * - Phải là số dương hoặc bằng 0
     */
    @Min(value = 0, message = "STOCK_QUANTITY_MUST_BE_POSITIVE_OR_ZERO")
    int stockQuantity;
}
