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
    
    /**
     * Tên vai trò
     * - Không được để trống
     * 
     * Ví dụ: ADMIN, USER, SHOP, CUSTOMER
     */
    @NotBlank(message = "ROLE_NAME_NOT_NULL")
    String name;

    /**
     * Mô tả vai trò (tùy chọn)
     */
    String description;
    
    /**
     * Danh sách quyền được gán cho vai trò này (tùy chọn)
     */
    Set<String> permissions;
}
