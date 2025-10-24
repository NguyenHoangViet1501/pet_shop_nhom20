package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductVariantRequest {
    
    /**
     * Tên biến thể (tùy chọn)
     * - Từ 1-255 ký tự nếu được cung cấp
     */
    @Size(min = 1, max = 255, message = "VARIANT_NAME_SIZE_INVALID")
    String variantName;
    
    /**
     * ID hình ảnh sản phẩm (tùy chọn)
     * - Phải là số dương nếu được cung cấp
     */
    @Positive(message = "PRODUCT_IMAGE_ID_MUST_BE_POSITIVE")
    Integer productImageId;
    
    /**
     * Khối lượng (tùy chọn)
     * - Phải là số dương nếu được cung cấp
     */
    @Positive(message = "WEIGHT_MUST_BE_POSITIVE")
    Float weight;
    
    /**
     * Giá (tùy chọn)
     * - Phải là số dương hoặc bằng 0 nếu được cung cấp
     */
    @PositiveOrZero(message = "VARIANT_PRICE_MUST_BE_POSITIVE_OR_ZERO")
    Float price;
    
    /**
     * Số lượng tồn kho (tùy chọn)
     * - Phải là số dương hoặc bằng 0
     */
    @Min(value = 0, message = "STOCK_QUANTITY_MUST_BE_POSITIVE_OR_ZERO")
    int stockQuantity;
    
    /**
     * Trạng thái xóa
     * - Chỉ chấp nhận: 0 (chưa xóa) hoặc 1 (đã xóa)
     */
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_INVALID")
    String isDeleted;
}
