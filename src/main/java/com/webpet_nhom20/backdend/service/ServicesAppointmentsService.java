package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointment.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import com.webpet_nhom20.backdend.dto.response.UserServiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicesAppointmentsService {
    public ServiceAppointmentsResponse create(ServiceAppointmentsRequest request);

    public List<UserServiceResponse> getAppointmentsByUserId(Integer userId);
}
