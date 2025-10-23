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

/**
 * Request để hủy lịch hẹn dịch vụ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelServiceAppointmentRequest {

    /**
     * ID của lịch hẹn cần hủy
     * - Không được để trống
     */
    @NotNull(message = "ID_NOT_NULL")
    private Integer id;
}
