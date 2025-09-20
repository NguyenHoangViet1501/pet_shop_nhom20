package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.UserCreationRequest;
import com.webpet_nhom20.backdend.dto.request.UserUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService  {

    public UserResponse createUser(UserCreationRequest request);

    public UserResponse updateUser(int userId, UserUpdateRequest request);

    public UserResponse getMyInfo();

    public UserResponse getUser(int id);

    public List<UserResponse> getUsers();


}
