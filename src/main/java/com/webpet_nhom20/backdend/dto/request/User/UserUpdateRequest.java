package com.webpet_nhom20.backdend.dto.request.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @Email(message = "EMAIL_INVALID")
    String email;
    @Size(min = 3 , message = "FULLNAME_INVALID")
    String fullName;
    @Size(min = 10 , message = "PHONE_INVALID")
    String phone;
}
