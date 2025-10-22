package com.webpet_nhom20.backdend.dto.request.ServicePet;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateServicePetRequest {
    @NotNull(message = "SERVICE_PET_NAME_IS_NOT_NULL")
    String name;
    @NotNull(message = "SERVICE_PET_TITLE_IS_NOT_NULL")
    String title;
    String description;
    @NotNull(message = "SERVICE_PET_DURATION_IS_NOT_NULL")
    Integer durationMinutes;
    @NotNull(message = "SERVICE_PET_PRICE_IS_NOT_NULL")
    BigDecimal price; // Đổi từ Float sang BigDecimal
}
