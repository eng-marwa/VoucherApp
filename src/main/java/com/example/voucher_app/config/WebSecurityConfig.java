package com.example.voucher_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.httpBasic();
            httpSecurity.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/api/users/all","/api/users/create").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/voucher/find/**").hasAnyRole("USER","ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/voucher/create").hasRole("ADMIN")
                    .and().csrf().disable();
            return httpSecurity.build();
        }
    }

