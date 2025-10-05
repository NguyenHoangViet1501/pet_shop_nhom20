package com.webpet_nhom20.backdend.controller;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointment.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ApiResponse;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import com.webpet_nhom20.backdend.service.ServicesAppointmentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class ServiceAppointmentsController {

    @Autowired
    private final ServicesAppointmentsService servicesAppointmentsService;

    @PostMapping
    public ResponseEntity<ApiResponse<ServiceAppointmentsResponse>> createAppointment(
            @Valid @RequestBody ServiceAppointmentsRequest request
    ) {
        ServiceAppointmentsResponse response = servicesAppointmentsService.create(request);

        return ResponseEntity.ok(
                ApiResponse.<ServiceAppointmentsResponse>builder()
                        .code(1000)
                        .success(true)
                        .message("Tạo lịch hẹn thành công")
                        .result(response)
                        .build()
        );
    }


}
