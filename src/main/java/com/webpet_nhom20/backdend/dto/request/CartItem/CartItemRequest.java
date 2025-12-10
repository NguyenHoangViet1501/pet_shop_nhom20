package com.webpet_nhom20.backdend.dto.request.CartItem;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemRequest {

    @NotNull(message = "PRODUCT_VARIANT_ID_IS_NOT_NULL")
    int productVariantId;
    @NotNull(message = "QUANTITY_IS_NOT_NULL")
    int quantity;
}