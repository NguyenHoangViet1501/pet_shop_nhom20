package com.webpet_nhom20.backdend.dto.request.Product_Image;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductImageRequest {
    String imageUrl;
    int position = 0;
    int isPrimary = 0;
    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted = "0";
}
