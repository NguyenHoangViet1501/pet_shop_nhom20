package com.webpet_nhom20.backdend.config;


import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String swaggerUrl = "http://localhost:8080/swagger-ui/index.html";
        System.out.println("Swagger : " + swaggerUrl);

    }
}
