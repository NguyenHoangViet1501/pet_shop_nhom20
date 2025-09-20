package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.request.UserCreationRequest;
import com.webpet_nhom20.backdend.dto.request.UserUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
