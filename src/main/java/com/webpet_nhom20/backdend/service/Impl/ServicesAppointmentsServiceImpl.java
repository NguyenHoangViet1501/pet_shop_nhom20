package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.common.CommonUtil;
import com.webpet_nhom20.backdend.mapper.ServiceAppointmentMapper;
import com.webpet_nhom20.backdend.repository.ServicesAppointmentsRepository;
import com.webpet_nhom20.backdend.repository.ServicesPetRespository;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.EmailService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public ServiceAppointmentsResponse create(ServiceAppointmentsRequest request) {
        ServicesPet servicesPet = servicesPetRespository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service không tồn tại"));

        ServiceAppointments appointment = serviceAppointmentMapper.toEntity(request);
        LocalDateTime appointmentEnd = request.getAppoinmentStart()
                .plusMinutes(servicesPet.getDurationMinutes());

        appointment.setAppoinmentEnd(appointmentEnd);

        ServiceAppointments saved = servicesAppointmentsRepository.save(appointment);
        try {
            User user = userRepository.findById(saved.getUserId().intValue())
                    .orElseThrow(() -> new RuntimeException("User không tồn tại"));

            String subject = CommonUtil.buildAppointmentEmailSubject(saved, user.getFullName(), user.getPhone());
            String htmlBody = CommonUtil.buildAppointmentEmailHtml(saved, user.getFullName(), user.getPhone(), servicesPet.getTitle());
            emailService.sendHtml(user.getEmail(), subject, htmlBody);
        } catch (Exception ex) {
            // Không chặn luồng chính nếu gửi mail lỗi
        }
        return serviceAppointmentMapper.toResponse(saved);
    }
}
