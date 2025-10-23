package com.webpet_nhom20.backdend.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshRequest {
    
    /**
     * JWT Token cần làm mới
     * - Không được để trống
     * - Token này sẽ được kiểm tra và tạo token mới
     */
    @NotBlank(message = "TOKEN_NOT_BLANK")
    String token;
}
