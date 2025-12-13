package com.webpet_nhom20.backdend.dto.response.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrandResponse {
    private String name;
    private Long count;

    public BrandResponse(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}
