package com.webpet_nhom20.backdend.dto.request.Role_Permission;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRequest {
    
    /**
     * Tên quyền
     * - Không được để trống
     * 
     * Ví dụ: CREATE_PRODUCT, UPDATE_USER, DELETE_ORDER
     */
    @NotBlank(message = "PERMISSION_NAME_NOT_BLANK")
    String name;

    /**
     * Mô tả quyền (tùy chọn)
     */
    String description;
}
