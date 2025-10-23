package com.webpet_nhom20.backdend.dto.request.ServiceAppointment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceAppointmentRequest {

    /**
     * ID của người dùng
     * - Không được để trống
     */
    @NotNull(message = "USER_ID_NOT_NULL")
    private Integer userId;

    /**
     * Tên vai trò của người dùng
     * - Không được để trống
     * 
     * Ví dụ: ADMIN, USER, CUSTOMER
     */
    @NotNull(message = "ROLE_NAME_NOT_NULL")
    private String roleName;
}
