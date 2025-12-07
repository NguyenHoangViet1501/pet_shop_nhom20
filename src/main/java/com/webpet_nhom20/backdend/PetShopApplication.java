package com.webpet_nhom20.backdend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class PetShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetShopApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry
//                        .addMapping("/**")
//                        .allowedOrigins("*") // Có thể thay bằng domain cụ thể cho an toàn
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//                        .allowedHeaders("*");
//            }
//        };
//    }
}
