package com.example.s0801.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

    // Tạo các user
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails teach = User
                .withUsername("teacher")
                .password("{noop}123123") // Nhớ có cái {noop}
                .roles("teacher")
                .build();
        UserDetails learn = User
                .withUsername("student")
                .password("{noop}123123")
                .roles("student")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}admin123")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(teach, learn, admin);
    }

    // Phân quyền user xem ai đc vào api nào
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET,"/api/students").hasAnyRole("student", "teacher", "admin")
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("student", "teacher", "admin")
                        .requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("teacher","admin")
                        .requestMatchers(HttpMethod.PUT,"/api/students").hasAnyRole( "teacher","admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole( "admin")
        );
        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf->csrf.disable()); // chống giả mạo // hình như dòng bên dưới là bản cập nhật
        http.csrf(AbstractHttpConfigurer::disable); // chống giả mạo
        return http.build();
    }
}
