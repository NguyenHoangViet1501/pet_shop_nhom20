package com.webpet_nhom20.backdend.dto.request.User;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE
)
public class UserCreationRequest {
    @NotBlank(message = "USERNAME_NOT_BLANK")
    @Size(min = 3 , message = "USERNAME_INVALID")
    String username;

    @NotBlank(message = "PASSWORD_NOT_BLANK")
    @Size(min = 8 , message = "PASSWORD_INVALID1")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "PASSWORD_INVALID2"
    )
    String password;

    @NotBlank(message = "EMAIL_NOT_BLANK")
    @Email(message = "EMAIL_INVALID")
    String email;

    @NotBlank(message = "FULLNAME_NOT_BLANK")
    @Size(min = 3 , message = "FULLNAME_INVALID")
    String fullName;

    @NotBlank(message = "PHONE_NOT_BLANK")
    @Size(min = 10 , message = "PHONE_INVALID")
    String phone;

}
