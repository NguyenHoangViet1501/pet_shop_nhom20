package com.webpet_nhom20.backdend.dto.request.ServicePet;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateServicePetRequest {
    String name;
    String title;
    String description;
    Integer durationMinutes;
    BigDecimal price; // Đổi từ Float sang BigDecimal để khớp với entity
    String isActive;
}
