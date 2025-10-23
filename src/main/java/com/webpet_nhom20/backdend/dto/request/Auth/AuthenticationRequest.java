package com.webpet_nhom20.backdend.dto.request.Auth;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    
    /**
     * Tên đăng nhập hoặc email để xác thực
     * - Không được để trống
     */
    @NotBlank(message = "IDENTIFIER_NOT_BLANK")
    String identifier;
    
    /**
     * Mật khẩu đăng nhập
     * - Không được để trống
     * - Tối thiểu 6 ký tự
     * - Phải chứa ít nhất: 1 chữ thường (a-z), 1 chữ HOA (A-Z), 
     *   1 chữ số (0-9) và 1 ký tự đặc biệt (@$!%*?&#)
     * 
     * Ví dụ hợp lệ: Password123!, MyP@ss2024, Secure#123
     */
    @NotBlank(message = "PASSWORD_NOT_BLANK")
    @Size(min = 6, message = "PASSWORD_INVALID_LENGTH")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "PASSWORD_INVALID_FORMAT"
    )
    String password;
}
