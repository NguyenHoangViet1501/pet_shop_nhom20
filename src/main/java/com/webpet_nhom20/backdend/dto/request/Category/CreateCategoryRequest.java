package com.webpet_nhom20.backdend.dto.request.Category;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCategoryRequest {

    @NotNull(message = "CATEGORY_NAME_IS_NOT_NULL")
    String name;
    String description ;
}
