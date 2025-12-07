package com.webpet_nhom20.backdend.dto.request.Product_Image;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ImageCreateDto {

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;

    private String publicId;

    private boolean isPrimary ;
    
    private int position = 0;
}
