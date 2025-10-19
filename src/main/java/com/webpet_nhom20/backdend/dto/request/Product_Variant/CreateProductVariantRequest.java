package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductVariantRequest {
    @NotNull(message = "PRODUCT_NAME_IS_NOT_NULL")
    int productId;
    @NotNull(message = "VARIANT_NAME_IS_NOT_NULL")
    String variantName;
    @NotNull(message = "VARIANT_WEIGHT_IS_NOT_NULL")
    Float weight;
    @NotNull(message = "VARIANT_PRICE_IS_NOT_NULL")
    Float price;
}
