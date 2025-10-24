package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Address.AddressRequest;
import com.webpet_nhom20.backdend.dto.response.Address.AddressResponse;
import com.webpet_nhom20.backdend.entity.Addresses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    Addresses toEntity(AddressRequest request);

    AddressResponse toResponse(Addresses address);
}
