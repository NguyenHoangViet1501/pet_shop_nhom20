package com.webpet_nhom20.backdend.dto.response.Category;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.webpet_nhom20.backdend.dto.response.Product.ProductResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

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
    String isFeatured;
    String isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatedDate;

    List<ProductResponse> products;


}
