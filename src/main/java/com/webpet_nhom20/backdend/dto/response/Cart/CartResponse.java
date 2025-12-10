package com.webpet_nhom20.backdend.dto.response.Cart;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webpet_nhom20.backdend.dto.response.CartItem.CartItemResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {

    int id;
    int userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatedDate;
    List<CartItemResponse> items;
}
