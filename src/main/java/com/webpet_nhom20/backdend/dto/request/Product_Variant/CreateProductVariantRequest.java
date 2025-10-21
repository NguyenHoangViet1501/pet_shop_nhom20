package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductVariantRequest {

    @NotNull(message = "PRODUCT_ID_IS_NOT_NULL")
    int productId;

    @NotNull(message = "PRODUCT_IMAGE_ID_IS_NOT_NULL")
    int productImageId;

    @NotNull(message = "VARIANT_NAME_IS_NOT_NULL")
    String variantName;

    Float weight;

    @NotNull(message = "VARIANT_PRICE_IS_NOT_NULL")
    @PositiveOrZero(message = "Giá không được âm")
    Float price;

    int stockQuantity;
}
