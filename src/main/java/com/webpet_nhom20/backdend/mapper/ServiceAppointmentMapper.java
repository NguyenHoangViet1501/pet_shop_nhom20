package com.webpet_nhom20.backdend.mapper;

import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import com.webpet_nhom20.backdend.dto.request.ServiceAppointment.ServiceAppointmentsRequest;
import com.webpet_nhom20.backdend.dto.response.ServiceAppointmentsResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ServiceAppointmentMapper {

    // Request -> Entity (khi tạo mới)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "appoinmentEnd", ignore = true) // sẽ tự tính
    @Mapping(target = "status", ignore = true) // default = SCHEDULED
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    ServiceAppointments toEntity(ServiceAppointmentsRequest request);

    // Entity -> Response
    ServiceAppointmentsResponse toResponse(ServiceAppointments entity);
}

