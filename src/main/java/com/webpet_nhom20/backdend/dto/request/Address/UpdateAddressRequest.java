package com.webpet_nhom20.backdend.dto.request.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateAddressRequest {

    @NotNull(message = "ID_NOT_NULL")
    int id;
    @NotNull(message = "CONTACT_NAME_IS_NOT_NULL")
    String contactName;
    @NotBlank(message = "PHONE_NOT_BLANK")
    @Size(min = 10 , message = "PHONE_INVALID")
    String phone;
    @NotBlank(message = "DETAIL_ADDRESS_IS_NOT_NULL")
    String detailAddress;
    @NotBlank(message = "CITY_IS_NOT_NULL")
    String city;
    @NotBlank(message = "STATE_IS_NOT_NULL")
    String state;
    @NotNull(message = "WARD_IS_NOT_NULL")
    String ward;

    String isDeleted;

    String isDefault;
}
