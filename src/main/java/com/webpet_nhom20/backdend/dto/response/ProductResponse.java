package com.webpet_nhom20.backdend.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    int id;
    int categoryId;
    String name;
    String shortDescription;
    String description;
    String price;
    String stockQuantity;
    String soldQuantity;
    String isDeleted;
    String isFeatured;
    String createdDate;
    String updatedDate;
}
