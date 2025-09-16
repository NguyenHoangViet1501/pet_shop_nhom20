package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }



}
