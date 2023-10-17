package com.wildcodeschool.oqsecuritychallenge.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.wildcodeschool.oqsecuritychallenge.entity.UserEntity;
import com.wildcodeschool.oqsecuritychallenge.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                UserEntity user = userRepository.findByUsername(username).get();
                System.out.println("@@@@" + user.getRole());
                return user.asUserDetails();
            }
        };
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/","/login").permitAll()
                .requestMatchers("/avengers/assemble").hasRole("CHAMPION")
                .requestMatchers("/secret-bases").hasRole("DIRECTOR")
            )
            .formLogin((form) -> form
                .defaultSuccessUrl("/") 
                .permitAll()
            )
            
            .logout((logout) -> logout
                .permitAll());

        return http.build();
    }
    
}
