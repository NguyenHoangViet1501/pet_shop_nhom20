package com.webpet_nhom20.backdend.dto.response.ProductVariant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariantResponse {
    int id;
    int productId;
    String variantName;
    Float weight;
    Float price;
    int stockQuantity ;
    int soldQuantity;
    String isDeleted ;
    @JsonFormat(pattern = "yyyy-MM-dd ")
    Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd ")
    Date updatedDate;
}
