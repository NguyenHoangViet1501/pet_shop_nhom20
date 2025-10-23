package com.webpet_nhom20.backdend.dto.request.Product_Image;

import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductImageRequest {
    
    /**
     * URL hình ảnh (tùy chọn)
     */
    String imageUrl;
    
    /**
     * Vị trí hiển thị hình ảnh (tùy chọn)
     */
    Integer position;
    
    /**
     * Ảnh chính của sản phẩm (tùy chọn)
     * - Chỉ chấp nhận: 0 (không phải ảnh chính) hoặc 1 (ảnh chính)
     */
    @Pattern(regexp = "^[01]$", message = "IS_PRIMARY_VALID")
    String isPrimary;
    
    /**
     * Trạng thái xóa
     * - Chỉ chấp nhận: 0 (chưa xóa) hoặc 1 (đã xóa)
     */
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted;
}
