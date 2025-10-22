package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.Category.CreateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.Category.UpdateCategoryRequest;
import com.webpet_nhom20.backdend.dto.request.ServicePet.CreateServicePetRequest;
import com.webpet_nhom20.backdend.dto.request.ServicePet.UpdateServicePetRequest;
import com.webpet_nhom20.backdend.dto.response.Category.CategoryResponse;
import com.webpet_nhom20.backdend.dto.response.ServicePet.ServicesPetResponse;
import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ServicesPetMapper {
    ServicesPetResponse toServicesPetResponse (ServicesPet servicesPet);
    ServicesPet toServicePet(CreateServicePetRequest request);

    void updateServicePet(@MappingTarget ServicesPet servicesPet, UpdateServicePetRequest request);
    
    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
    
    @Condition
    default boolean isNotNull(Integer value) {
        return value != null;
    }
    
    @Condition
    default boolean isNotNull(BigDecimal value) {
        return value != null;
    }
}
