package com.webpet_nhom20.backdend.controller;


import com.webpet_nhom20.backdend.dto.request.Role_Permission.PermissionRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.PermissionResponse;
import com.webpet_nhom20.backdend.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @PostMapping("/create-permission")
    ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request) {
        PermissionResponse permission = permissionService.create(request);
        return ApiResponse.<PermissionResponse>builder()
                .success(true)
                .result(permission)
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .success(true)
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<String> delete(@PathVariable String permission) {
        permissionService.delete(permission);
        return ApiResponse.<String>builder()
                .success(true)
                .result("Permission has been deleted")
                .build();
    }
}
