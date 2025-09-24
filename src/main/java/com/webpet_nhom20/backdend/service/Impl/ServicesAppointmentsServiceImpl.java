package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import com.webpet_nhom20.backdend.mapper.ServiceAppointmentMapper;
import com.webpet_nhom20.backdend.repository.ServicesAppointmentsRepository;
import com.webpet_nhom20.backdend.repository.ServicesPetRespository;
import com.webpet_nhom20.backdend.service.ServicesAppointmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ServicesAppointmentsServiceImpl implements ServicesAppointmentsService {
    @Autowired
    private ServicesPetRespository servicesPetRespository;

    @Autowired
    private ServicesAppointmentsRepository servicesAppointmentsRepository;

    @Autowired
    private ServiceAppointmentMapper serviceAppointmentMapper;

    @Override
    public ServiceAppointmentsResponse create(ServiceAppointmentsRequest request) {
        ServicesPet servicesPet = servicesPetRespository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service không tồn tại"));

        ServiceAppointments appointment = serviceAppointmentMapper.toEntity(request);
        LocalDateTime appointmentEnd = request.getAppoinmentStart()
                .plusMinutes(servicesPet.getDurationMinutes());

        appointment.setAppoinmentEnd(appointmentEnd);

        ServiceAppointments saved = servicesAppointmentsRepository.save(appointment);
        return serviceAppointmentMapper.toResponse(saved);
    }
}
