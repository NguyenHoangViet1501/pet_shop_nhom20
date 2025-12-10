package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Cart.CartRequest;
import com.webpet_nhom20.backdend.dto.response.Cart.CartResponse;

public interface CartService {
    CartResponse addToCart(CartRequest request, String token);
    CartResponse getCart(String token);
    void removeItem(Integer itemId, String token);
}
