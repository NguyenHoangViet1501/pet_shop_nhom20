package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.response.Cloudinary.CloudinaryResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    public CloudinaryResponse uploadFile(MultipartFile file,String fileName);
}
