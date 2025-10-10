package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.ServiceAppointment.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import com.webpet_nhom20.backdend.dto.response.UserServiceResponse;
import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import com.webpet_nhom20.backdend.common.CommonUtil;
import com.webpet_nhom20.backdend.mapper.ServiceAppointmentMapper;
import com.webpet_nhom20.backdend.repository.ServicesAppointmentsRepository;
import com.webpet_nhom20.backdend.repository.ServicesPetRespository;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.AsyncEmailService;
import com.webpet_nhom20.backdend.service.EmailService;
import com.webpet_nhom20.backdend.service.ServicesAppointmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    AsyncEmailService asyncEmailService;

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
            userRepository.findById(saved.getUserId().intValue()).ifPresent(user -> {
                String subject = CommonUtil.buildAppointmentEmailSubject(saved, user.getFullName(), user.getPhone());
                String htmlBody = CommonUtil.buildAppointmentEmailHtml(saved, user.getFullName(), user.getPhone(), servicesPet.getTitle());
                asyncEmailService.sendAppointmentEmail(user.getEmail(), subject, htmlBody);
            });
        } catch (Exception ex) {
            // Không chặn luồng chính nếu gửi mail lỗi
        }
        ServiceAppointmentsResponse response = serviceAppointmentMapper.toResponse(saved);

        response.setServiceName(servicesPet.getTitle());

        return response;
    }

    @Override
    public List<UserServiceResponse> getAppointmentsByUserId(Integer userId) {
        List<ServiceAppointments> appointments = servicesAppointmentsRepository.findScheduledAppointmentsByUserId(userId);

        List<UserServiceResponse> userServiceResponses = new ArrayList<>();
        for(ServiceAppointments sa : appointments){
            ServicesPet service = servicesPetRespository.findById(sa.getServiceId()).orElse(null);

            UserServiceResponse response = new UserServiceResponse();
            response.setId(sa.getId());
            response.setServiceTitle(service != null ? service.getTitle() : null);
            response.setNamePet(sa.getNamePet());
            response.setSpeciePet(sa.getSpeciePet());
            response.setAppointmentStart(sa.getAppoinmentStart());
            response.setAppointmentEnd(sa.getAppoinmentEnd());
            response.setStatus(sa.getStatus());

            userServiceResponses.add(response);
        }
        return userServiceResponses;
    }
}
