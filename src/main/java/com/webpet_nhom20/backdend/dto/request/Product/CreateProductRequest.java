package com.webpet_nhom20.backdend.dto.request.Product;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {

    @NotNull(message = "CATEGORY_NAME_IS_NOT_NULL")
    int categoryId;
    @NotNull(message = "PRODUCT_NAME_IS_NOT_NULL")
    String name;
    String shortDescription ;
    String description ;
    @NotNull(message = "PRODUCT_PRICE_IS_NOT_NULL")
    float price;
}
