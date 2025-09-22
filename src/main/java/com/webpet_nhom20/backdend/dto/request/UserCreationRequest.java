package com.webpet_nhom20.backdend.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE
)
public class UserCreationRequest {
    @NotBlank(message = "Username is not null")
    @Size(min = 3 , message = "USERNAME_INVALID")
    String username;

    @NotBlank(message = "Password is not null")
    @Size(min = 8 , message = "PASSWORD_INVALID")
    String password;

    @NotBlank(message = "Email is not null")
    @Size(min = 5 , message = "EMAIL_INVALID")
    String email;

    @NotBlank(message = "Fullname is not null")
    @Size(min = 3 , message = "FULLNAME_INVALID")
    String fullName;

    @NotBlank(message = "Phone is not null")
    @Size(min = 10 , message = "PHONE_INVALID")
    String phone;

}
