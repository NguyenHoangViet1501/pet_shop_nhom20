package com.webpet_nhom20.backdend.service.Impl;

import com.cloudinary.Cloudinary;
import com.webpet_nhom20.backdend.dto.response.Cloudinary.CloudinaryResponse;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;
    @Transactional
    @Override
    public CloudinaryResponse uploadFile(MultipartFile file , String fileName) {
        try {
            final Map result = cloudinary.uploader().upload(file.getBytes(), Map.of("public_id", "petshop/product" + fileName));
            final String url =(String) result.get("secure_url");
            final String publicId =(String) result.get("public_id");
            return CloudinaryResponse.builder()
                    .url(url)
                    .publicId(publicId)
                    .build();
        }catch (Exception e){
            throw new AppException(ErrorCode.FAIL_TO_UPLOAD_FILE);
        }
    }
}
