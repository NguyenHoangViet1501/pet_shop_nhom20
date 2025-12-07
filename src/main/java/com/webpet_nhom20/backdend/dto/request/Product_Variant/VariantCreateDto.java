package com.webpet_nhom20.backdend.dto.request.Product_Variant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class VariantCreateDto {
    @NotBlank(message = "Variant name cannot be blank")
    private String variantName;

    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price must be zero or positive")
    private Float price;
    @NotNull(message = "Weight cannot be null")
    private Float weight;

    @PositiveOrZero(message = "Stock must be zero or positive")
    private int stockQuantity;

    // Danh sách các URL ảnh mà variant này được liên kết tới
    private List<String> associatedImageUrls;
}
