package com.webpet_nhom20.backdend.mapper;


import com.webpet_nhom20.backdend.dto.request.Role_Permission.RoleRequest;
import com.webpet_nhom20.backdend.dto.response.Role_Permission.RoleResponse;
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
