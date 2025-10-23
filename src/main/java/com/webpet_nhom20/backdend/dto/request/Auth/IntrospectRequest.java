package com.webpet_nhom20.backdend.dto.request.Auth;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IntrospectRequest {
    
    /**
     * JWT Token cần kiểm tra tính hợp lệ
     * - Không được để trống
     */
    @NotBlank(message = "TOKEN_NOT_BLANK")
    String token;
}
