package com.webpet_nhom20.backdend.dto.request.Product_Image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductImageRequest {
    
    /**
     * ID sản phẩm
     * - Không được để trống
     */
    @NotNull(message = "PRODUCT_ID_NOT_NULL")
    int productId;
    
    /**
     * URL hình ảnh
     * - Không được để trống
     */
    @NotBlank(message = "IMAGE_URL_NOT_BLANK")
    String imageUrl;
}
