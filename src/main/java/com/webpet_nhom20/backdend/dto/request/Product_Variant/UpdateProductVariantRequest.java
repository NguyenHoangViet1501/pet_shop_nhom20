package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductVariantRequest {
    String variantName;
    Integer productImageId;
    Float weight;
    Float price;
    int stockQuantity;
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted ;
}
