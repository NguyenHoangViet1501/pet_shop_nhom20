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
    int categoryId;
    String name;
    String shortDescription ;
    String description ;
    float price;
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted = "0";
    @Pattern(regexp = "^[01]?$", message = "IS_FEATURED_VALID")
    String isFeatured = "0";
}
