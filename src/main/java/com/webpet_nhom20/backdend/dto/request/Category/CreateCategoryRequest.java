package com.webpet_nhom20.backdend.dto.request.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCategoryRequest {

    /**
     * Tên danh mục
     * - Không được để trống
     * 
     * Ví dụ: Thức ăn cho chó, Phụ kiện cho mèo, Đồ chơi thú cưng
     */
    @NotBlank(message = "CATEGORY_NAME_IS_NOT_NULL")
    String name;
    
    /**
     * Mô tả danh mục (tùy chọn)
     */
    String description;
}
