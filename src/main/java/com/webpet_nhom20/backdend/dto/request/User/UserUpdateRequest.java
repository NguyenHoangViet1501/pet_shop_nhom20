package com.webpet_nhom20.backdend.dto.request.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    /**
     * Địa chỉ email (tùy chọn)
     * - Phải đúng định dạng email nếu được cung cấp
     */
    @Email(message = "EMAIL_INVALID")
    String email;
    
    /**
     * Họ và tên đầy đủ (tùy chọn)
     * - Tối thiểu 3 ký tự nếu được cung cấp
     */
    @Size(min = 3, message = "FULLNAME_INVALID")
    String fullName;
    
    /**
     * Số điện thoại (tùy chọn)
     * - Tối thiểu 10 ký tự
     * - Format: 0xxxxxxxxx hoặc +84xxxxxxxxx
     * - Hỗ trợ các đầu số: 03, 05, 07, 08, 09
     * 
     * Ví dụ hợp lệ: 0912345678, +84912345678, 0912 345 678
     */
    @Size(min = 10, message = "PHONE_INVALID")
    @Pattern(
            regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "PHONE_FORMAT_INVALID"
    )
    String phone;
}
