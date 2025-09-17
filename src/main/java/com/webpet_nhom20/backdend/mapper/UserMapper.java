package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
}
