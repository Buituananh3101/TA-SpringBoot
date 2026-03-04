package com.example.s0801.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {

    // Có tk này thì ko cần InMemoryUserDetailsManager nữa
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select id, pw, active from accounts where id = ?"); // thêm để set bảng user
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select id, role from roles where id = ?"); // thêm để set bảng authorities
        return jdbcUserDetailsManager;
    }

//    // Tạo các user
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails teach = User
//                .withUsername("teacher")
//                .password("{noop}123123") // Nhớ có cái {noop}
//                .roles("teacher")
//                .build();
//        UserDetails learn = User
//                .withUsername("student")
//                .password("{noop}123123")
//                .roles("student")
//                .build();
//        UserDetails admin = User
//                .withUsername("admin")
//                .password("{noop}admin123")
//                .roles("admin")
//                .build();
//        return new InMemoryUserDetailsManager(teach, learn, admin);
//    }

    // Phân quyền user xem ai đc vào api nào
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET,"/api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/students").hasAnyRole( "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole( "ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf->csrf.disable()); // chống giả mạo // hình như dòng bên dưới là bản cập nhật
        http.csrf(AbstractHttpConfigurer::disable); // chống giả mạo
        return http.build();
    }
}
