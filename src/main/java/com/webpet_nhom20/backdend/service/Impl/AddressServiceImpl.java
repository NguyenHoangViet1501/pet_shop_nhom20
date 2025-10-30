package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.config.JwtTokenProvider;
import com.webpet_nhom20.backdend.dto.request.Address.AddressRequest;
import com.webpet_nhom20.backdend.dto.response.Address.AddressResponse;
import com.webpet_nhom20.backdend.entity.Addresses;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.AddressMapper;
import com.webpet_nhom20.backdend.repository.AddressRepository;
import com.webpet_nhom20.backdend.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public Page<AddressResponse> getAddressById(String token, Pageable pageable) {
        Integer userIdFromToken = jwtTokenProvider.getUserId(token);

        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(
                        Sort.Order.desc("isDefault"),
                        Sort.Order.desc("createdDate")
                )
        );

        Page<Addresses> addressPage = addressRepository.findAllByUserIdAndIsDeleted(userIdFromToken, "0", sortedPageable);

        if (addressPage.isEmpty()){
            throw new AppException(ErrorCode.IS_EMPTY);
        }

        Page<AddressResponse> responsePage = addressPage.map(addressMapper::toResponse);

        return responsePage;

    }

    @Override
    public AddressResponse createAddress(String token, AddressRequest request) {
        Integer userId = jwtTokenProvider.getUserId(token);

        Addresses newAddress = addressMapper.toEntity(request);
        newAddress.setUserId(userId);

        List<Addresses> userAddresses = addressRepository.findByUserId(userId);

        if (userAddresses.isEmpty()) {
            newAddress.setIsDefault("1");
        }else if ("1".equals(request.getIsDefault())) {
            // Nếu user đã có địa chỉ mặc định mà request này muốn set mặc định
            for (Addresses addr : userAddresses) {
                if ("1".equals(addr.getIsDefault())) {
                    addr.setIsDefault("0");
                }
            }
            addressRepository.saveAll(userAddresses);
            newAddress.setIsDefault("1");
        }
        else {
            newAddress.setIsDefault("0");
        }

        Addresses savedAddress = addressRepository.save(newAddress);

        return addressMapper.toResponse(savedAddress);
    }
}
