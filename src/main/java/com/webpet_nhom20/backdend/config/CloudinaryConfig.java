package com.webpet_nhom20.backdend.config;


import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinaryName}")
    private String cloudinaryName;
    @Value("${cloudinaryKey}")
    private String cloudinaryKey;
    @Value("${cloudinarySecretKey}")
    private String cloudinarySecretKey;


    @Bean
    public Cloudinary cloudinary(){
        final Map<String, String > config = new HashMap<>();
        config.put("cloud_name",cloudinaryName);
        config.put("api_key",cloudinaryKey);
        config.put("api_secret",cloudinarySecretKey);
        return new Cloudinary(config);
    }
}
