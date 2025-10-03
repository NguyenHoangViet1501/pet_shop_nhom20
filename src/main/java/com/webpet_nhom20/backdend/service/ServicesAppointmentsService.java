package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import org.springframework.stereotype.Service;

@Service
public interface ServicesAppointmentsService {
    public ServiceAppointmentsResponse create(ServiceAppointmentsRequest request);
}
