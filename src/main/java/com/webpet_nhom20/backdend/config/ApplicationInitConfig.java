package com.webpet_nhom20.backdend.config;

import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.enums.UserRole;
import com.webpet_nhom20.backdend.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ApplicationInitConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner (UserRepository userRepository){
        return args -> {
            if(userRepository.findByUsername("admin").isEmpty()){
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .email("admin@gmail.com")
                        .fullName("Admin")
                        .phone("0123456789")
                        .roles(UserRole.SHOP.name())
                        .build();

                userRepository.save(user);
            }

            if(userRepository.findByUsername("customer").isEmpty()){
                User customer = User.builder()
                        .username("customer")
                        .password(passwordEncoder.encode("customer"))
                        .email("customer@gmail.com")
                        .fullName("Customer Test")
                        .phone("0987654321")
                        .roles(UserRole.CUSTOMER.name())
                        .build();
                userRepository.save(customer);
            }
        };
    }
}
