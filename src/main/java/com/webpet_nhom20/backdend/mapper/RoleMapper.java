package com.webpet_nhom20.backdend.mapper;


import com.webpet_nhom20.backdend.dto.request.RoleRequest;
import com.webpet_nhom20.backdend.dto.response.RoleResponse;
import com.webpet_nhom20.backdend.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
