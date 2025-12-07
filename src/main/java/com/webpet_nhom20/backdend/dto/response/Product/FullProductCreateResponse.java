package com.webpet_nhom20.backdend.dto.response.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullProductCreateResponse {
    private Integer productId;
    private String message;
}
