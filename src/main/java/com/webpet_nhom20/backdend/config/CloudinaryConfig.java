package com.webpet_nhom20.backdend.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        final Map<String, String > config = new HashMap<>();
        config.put("cloud_name","di2a8fvuv");
        config.put("api_key","952239256585686");
        config.put("api_secret","yR2fnx-fYqQDDzGX0Ex_vfiN47Q");
        return new Cloudinary(config);
    }
}
