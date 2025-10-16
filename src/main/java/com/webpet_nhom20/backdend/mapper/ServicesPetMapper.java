package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.response.Service.ServicesPetResponse;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicesPetMapper {
    ServicesPetResponse toServicesPetResponse (ServicesPet servicesPet);



    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
