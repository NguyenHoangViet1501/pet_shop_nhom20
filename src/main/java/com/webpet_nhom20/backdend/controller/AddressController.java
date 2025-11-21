package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.request.Address.AddressRequest;
import com.webpet_nhom20.backdend.dto.request.Address.UpdateAddressRequest;
import com.webpet_nhom20.backdend.dto.response.Address.AddressResponse;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;
    @GetMapping("/user-addresses")
    public ResponseEntity<ApiResponse<List<AddressResponse>>> getUserAddresses(
            @RequestHeader("Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AddressResponse> addressPage = addressService.getAddressById(token, pageable);
        ApiResponse<List<AddressResponse>> response = ApiResponse.<List<AddressResponse>>builder()
                .success(true)
                .message("Get addresses successfully")
                .result(addressPage.getContent())
                .currentPage(addressPage.getNumber())
                .pageSize(addressPage.getSize())
                .totalElements(addressPage.getTotalElements())
                .totalPages(addressPage.getTotalPages())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AddressResponse>> createAddress(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody AddressRequest request
    ) {

        AddressResponse response = addressService.createAddress(token, request);

        return ResponseEntity.ok(
                ApiResponse.<AddressResponse>builder()
                        .success(true)
                        .message("Create address successfully")
                        .result(response)
                        .build()
        );
    }
    @PostMapping("/update")
    public ResponseEntity<ApiResponse<AddressResponse>> updateAddress(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody UpdateAddressRequest request
    ) {
        AddressResponse response = addressService.updateAddress(token, request);

        return ResponseEntity.ok(
                ApiResponse.<AddressResponse>builder()
                        .success(true)
                        .message("Update address successfully")
                        .result(response)
                        .build()
        );
    }
}
