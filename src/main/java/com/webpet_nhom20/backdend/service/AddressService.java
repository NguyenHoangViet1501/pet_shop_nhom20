package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Address.AddressRequest;
import com.webpet_nhom20.backdend.dto.request.Address.UpdateAddressRequest;
import com.webpet_nhom20.backdend.dto.response.Address.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {

    public Page<AddressResponse> getAddressById(String token, Pageable pageable);

    public AddressResponse createAddress(String token, AddressRequest request);

    public AddressResponse updateAddress(String token, UpdateAddressRequest request);

    public void deleteAddress(String token, Integer addressId);
}
