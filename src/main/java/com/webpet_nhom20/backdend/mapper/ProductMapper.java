package com.webpet_nhom20.backdend.mapper;


import com.webpet_nhom20.backdend.dto.response.ProductResponse;
import com.webpet_nhom20.backdend.entity.Products;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Products products);
    List<ProductResponse> toProductResponses(List<Products> products);
}
