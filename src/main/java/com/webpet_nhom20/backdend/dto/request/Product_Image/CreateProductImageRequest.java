package com.webpet_nhom20.backdend.dto.request.Product_Image;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductImageRequest {
    @NotNull(message = "CATEGORY_NAME_IS_NOT_NULL")
    int productId;
    String imageUrl;
    int isPrimary = 0;
}
