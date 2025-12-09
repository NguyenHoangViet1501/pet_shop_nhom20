package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Address.AddressRequest;
import com.webpet_nhom20.backdend.dto.response.Address.AddressResponse;
import com.webpet_nhom20.backdend.entity.Addresses;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class AddressMapper {

    @Autowired
    private UserRepository userRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    public abstract Addresses toEntity(AddressRequest request);

    public abstract AddressResponse toResponse(Addresses address);

    protected User mapUserIdToUser(Integer userId) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
