package com.webpet_nhom20.backdend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponse {
    int id;
    String name;
    String description;
    String isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String updatedDate;

}
