package com.webpet_nhom20.backdend.mapper;


import com.webpet_nhom20.backdend.dto.request.Role_Permission.PermissionRequest;
import com.webpet_nhom20.backdend.dto.response.PermissionResponse;
import com.webpet_nhom20.backdend.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    //    @Mapping(source = "lastName",target = "firstName")
    PermissionResponse toPermissionResponse(Permission permission);
    //    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
