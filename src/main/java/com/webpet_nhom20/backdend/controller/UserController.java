package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.User.UserCreationRequest;
import com.webpet_nhom20.backdend.dto.request.User.UserUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.UserResponse;
import com.webpet_nhom20.backdend.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        return ApiResponse.<UserResponse>builder()
                .success(true)
                .message("Create user successfully")
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponse> getMyInfo(){
        UserResponse user = userService.getMyInfo();
        return ApiResponse.<UserResponse>builder()
                .result(user)
                .build();
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable int userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }


    @GetMapping()
    ApiResponse<List<UserResponse>> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities().forEach(grantedAuthority ->  log.info(grantedAuthority.getAuthority()));
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }
    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") int userId){
        UserResponse user = userService.getUser(userId);
        return ApiResponse.<UserResponse>builder()
                .result(user)
                .build();
    }



}
