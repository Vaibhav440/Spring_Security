package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class AppSecurity {

    @Bean
    public SecurityFilterChain securityconfig(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(req -> req
                .antMatchers("/save").permitAll() // ✅ /save is open to all
                .anyRequest().authenticated()        // 🔒 All others need auth
            )
            .httpBasic()      // Use HTTP Basic Authentication
            .and()
            .csrf().disable(); // Disable CSRF for API use

        return http.build(); // ✅ Required to finalize configuration
    }
}
