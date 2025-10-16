package com.webpet_nhom20.backdend.dto.request.Category;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCategoryRequest {

    String name;
    String description;

    @Pattern(regexp = "^[01]?$", message = "IS_DELETED_VALID")
    String isDeleted;

    @Pattern(regexp = "^[01]?$", message = "IS_FEATURED_VALID")
    String isFeatured;
}
