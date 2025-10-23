package com.webpet_nhom20.backdend.dto.request.Product;

import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductRequest {
    
    /**
     * ID danh mục sản phẩm (tùy chọn)
     */
    int categoryId;
    
    /**
     * Tên sản phẩm (tùy chọn)
     */
    String name;
    
    /**
     * Mô tả ngắn (tùy chọn)
     */
    String shortDescription;
    
    /**
     * Mô tả chi tiết (tùy chọn)
     */
    String description;
    
    /**
     * Trạng thái xóa
     * - Chỉ chấp nhận: 0 (chưa xóa) hoặc 1 (đã xóa)
     */
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted;
    
    /**
     * Trạng thái nổi bật
     * - Chỉ chấp nhận: 0 (không nổi bật) hoặc 1 (nổi bật)
     */
    @Pattern(regexp = "^[01]?$", message = "IS_FEATURED_VALID")
    String isFeatured;
}
