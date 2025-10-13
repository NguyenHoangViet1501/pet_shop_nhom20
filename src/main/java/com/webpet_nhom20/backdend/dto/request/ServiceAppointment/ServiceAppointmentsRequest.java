package com.webpet_nhom20.backdend.dto.request.ServiceAppointment;

import com.webpet_nhom20.backdend.enums.AppoinmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceAppointmentsRequest {
    @NotNull(message = "SERVICE_ID_NOT_NULL")
    private Integer serviceId;

    @NotNull(message = "USER_ID_NOT_NULL")
    private Long userId;

    @NotBlank(message = "NAME_PET_NOT_BLANK")
    @Size(max = 100, message = "NAME_PET_TOO_LONG")
    private String namePet;

    @NotNull(message = "APPOINTMENT_START_NOT_NULL")
    @Future(message = "APPOINTMENT_START_NOT_FUTURE")
    private LocalDateTime appoinmentStart;

    // Có thể để optional, default = SCHEDULED khi xử lý trong service
    private AppoinmentStatus status;

    @Size(max = 500, message = "NOTES_TOO_LONG")
    private String notes;
}
