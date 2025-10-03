package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.UserCreationRequest;
import com.webpet_nhom20.backdend.dto.request.UserUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.enums.UserRole;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.UserService;
import com.webpet_nhom20.backdend.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        if(userRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(UserRole.CUSTOMER.name());

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(int userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTS));
        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS));
        return userMapper.toUserResponse(user);

    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(int id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS))) ;
    }

    @PreAuthorize("hasRole('SHOP')")
    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

}
