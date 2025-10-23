package com.webpet_nhom20.backdend.dto.request.Category;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCategoryRequest {

    /**
     * Tên danh mục (tùy chọn)
     */
    String name;
    
    /**
     * Mô tả danh mục (tùy chọn)
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
