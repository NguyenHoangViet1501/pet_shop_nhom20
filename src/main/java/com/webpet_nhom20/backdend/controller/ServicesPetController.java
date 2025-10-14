package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.ServicesPetResponse;
import com.webpet_nhom20.backdend.service.ServicesPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServicesPetController {
    @Autowired
    private final ServicesPetService services;

    @GetMapping("/active")
    public ApiResponse<List<ServicesPetResponse>> getActiveSerices(){
        List<ServicesPetResponse> servicesPetResponseList = services.getActiveServices();

        return ApiResponse.<List<ServicesPetResponse>>builder()
                .result(servicesPetResponseList)
                .success(true)
                .message("Lấy dịch vụ thành công")
                .build();
    }
}
