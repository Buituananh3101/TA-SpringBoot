package com.example.s0801.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfiguration {

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
                .password("{noop}123123")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(teach, learn, admin);
    }
}
