package com.webpet_nhom20.backdend.dto.request;


import lombok.Data;

import java.util.List;

@Data

public class OrderRequest {


    @Data
    public static class ProductRequest{
        String productName;
        List<Integer> productVariantId;


    }


}
