package com.webpet_nhom20.backdend.dto.response.Auth;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
