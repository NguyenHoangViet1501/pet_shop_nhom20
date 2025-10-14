package com.webpet_nhom20.backdend.dto.request.ServiceAppointment;

import com.webpet_nhom20.backdend.enums.AppoinmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateServiceAppointmentRequest {

    @NotNull(message = "ID_NOT_NULL")
    private Integer id;

    @NotNull(message = "SERVICE_ID_NOT_NULL")
    private Integer serviceId;

    @NotBlank(message = "NAME_PET_NOT_BLANK")
    @Size(max = 100, message = "NAME_PET_TOO_LONG")
    private String namePet;

    @NotBlank(message = "SPECIE_PET_NOT_BLANK")
    @Size(max = 100, message = "SPECIE_PET_TOO_LONG")
    private String speciePet;

    @NotNull(message = "APPOINTMENT_START_NOT_NULL")
    @Future(message = "APPOINTMENT_START_NOT_FUTURE")
    private LocalDateTime appoinmentStart;

    private AppoinmentStatus status;

    @Size(max = 500, message = "NOTES_TOO_LONG")
    private String notes;
}
