package com.webpet_nhom20.backdend.dto.request.Role_Permission;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {
    @NotBlank
    String name;

    String description;
    Set<String> permissions;
}
