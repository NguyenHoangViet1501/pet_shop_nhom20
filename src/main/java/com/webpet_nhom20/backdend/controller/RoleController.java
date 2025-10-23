package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Role_Permission.RoleRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.Role_Permission.RoleResponse;
import com.webpet_nhom20.backdend.service.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping("/create-role")
    ApiResponse<RoleResponse> create(@Valid @RequestBody RoleRequest request) {
        RoleResponse role = roleService.create(request);
        return ApiResponse.<RoleResponse>builder().success(true).result(role).build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .success(true)
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<String> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<String>builder()
                .success(true)
                .result("Role has been deleted")
                .build();
    }
}
