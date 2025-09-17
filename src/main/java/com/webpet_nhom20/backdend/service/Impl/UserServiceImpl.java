package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.UserService;
import com.webpet_nhom20.backdend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }
}
