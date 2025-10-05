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
    @NotNull(message = "Service ID không được để trống")
    private Integer serviceId;

    @NotNull(message = "User ID không được để trống")
    private Long userId;

    @NotBlank(message = "Tên thú cưng không được để trống")
    @Size(max = 100, message = "Tên thú cưng không vượt quá 100 ký tự")
    private String namePet;

    @NotNull(message = "Thời gian bắt đầu không được để trống")
    @Future(message = "Thời gian bắt đầu phải là thời gian trong tương lai")
    private LocalDateTime appoinmentStart;

    // Có thể để optional, default = SCHEDULED khi xử lý trong service
    private AppoinmentStatus status;

    @Size(max = 500, message = "Ghi chú không vượt quá 500 ký tự")
    private String notes;
}
