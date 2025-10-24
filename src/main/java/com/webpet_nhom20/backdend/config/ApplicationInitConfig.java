package com.webpet_nhom20.backdend.config;

import com.webpet_nhom20.backdend.entity.Role;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.enums.UserRole;
import com.webpet_nhom20.backdend.repository.RoleRepository;
import com.webpet_nhom20.backdend.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    @Bean
    ApplicationRunner applicationRunner (UserRepository userRepository,
                                         RoleRepository roleRepository){
        return args -> {
            // ===== ROLE =====
            var roleShop = roleRepository.findById("SHOP").orElseGet(() -> {
                Role newRole = Role.builder()
                        .name("SHOP")
                        .description("Shop role")
                        .build();
                roleRepository.save(newRole);
                log.warn("Role Shop has been created.");
                return newRole;
            });


            var roleCustomer = roleRepository.findById("CUSTOMER").orElseGet(() -> {
                Role newRole = Role.builder()
                        .name("CUSTOMER")
                        .description("Customer role")
                        .build();
                roleRepository.save(newRole);
                log.warn("Role CUSTOMER has been created.");
                return newRole;
            });



            // ===== USERS =====
            if(userRepository.findByUsername("admin").isEmpty()){
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("Admin123@"))
                        .email("admin@gmail.com")
                        .fullName("Admin")
                        .phone("0123456789")
                        .isDeleted("0")
                        .role(roleShop)
                        .build();

                userRepository.save(user);
            }

            if(userRepository.findByUsername("customer").isEmpty()){
                User customer = User.builder()
                        .username("customer")
                        .password(passwordEncoder.encode("Customer123@"))
                        .email("hoangvit2k4@gmail.com")
                        .fullName("Customer Test")
                        .phone("0987654321")
                        .isDeleted("0")
                        .role(roleCustomer)
                        .build();
                userRepository.save(customer);
            }
        };
    }
}
