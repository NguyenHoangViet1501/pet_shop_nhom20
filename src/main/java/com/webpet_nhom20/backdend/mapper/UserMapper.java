package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.User.UserCreationRequest;
import com.webpet_nhom20.backdend.dto.request.User.UserUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.User.UserResponse;
import com.webpet_nhom20.backdend.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toUser(UserCreationRequest request);

    @Mapping(target = "roles", source = "role.name")
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);


    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
