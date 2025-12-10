package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.request.Cart.CartRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Cart.CartResponse;
import com.webpet_nhom20.backdend.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    @Autowired
    private final CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<ApiResponse<CartResponse>> createCart(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid CartRequest request
    ){
        CartResponse cartResponse = cartService.addToCart(request, token);

        ApiResponse<CartResponse> response = ApiResponse.<CartResponse>builder()
                .success(true)
                .message("Cart created successfully")
                .result(cartResponse)
                .build();

        return ResponseEntity.ok(response);
    }
    @GetMapping("")
    public ResponseEntity<ApiResponse<CartResponse>> getCart(
            @RequestHeader("Authorization") String token
    ){
        CartResponse cartResponse = cartService.getCart(token);

        ApiResponse<CartResponse> response = ApiResponse.<CartResponse>builder()
                .success(true)
                .message("Get cart successfully")
                .result(cartResponse)
                .build();

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/item/{itemId}")
    public ResponseEntity<ApiResponse<String>> removeItem(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer itemId
    ){
        cartService.removeItem(itemId, token);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Cart item deleted successfully")
                .result("Item " + itemId + " removed")
                .build();

        return ResponseEntity.ok(response);
    }
}
