package com.webpet_nhom20.backdend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.webpet_nhom20.backdend.enums.AppoinmentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceResponse {
    Long id;
    String serviceTitle;
    String namePet;
    String speciePet;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime appointmentStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime appointmentEnd;
    AppoinmentStatus status;

}
