package com.bhautik.bsm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // ❌ CSRF Disable for APIs
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Authentication APIs Public
                        .requestMatchers("/api/**").authenticated() // Baki sab authorized users ke lie
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 🟢 Stateless Authentication
                .httpBasic(Customizer.withDefaults()) // ✅ Basic Auth Enable
                .formLogin(AbstractHttpConfigurer::disable) // ❌ Default Login Page Disable
                .build();
    }
}
