package com.webpet_nhom20.backdend.dto.request.Cart;

import com.webpet_nhom20.backdend.dto.request.CartItem.CartItemRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartRequest {

    List<CartItemRequest> items;
}
