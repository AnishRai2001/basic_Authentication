package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    // Inject your custom user details service
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//      http
//              .csrf(csrf -> csrf.disable())
//              .authorizeHttpRequests(auth -> auth
//                      .requestMatchers(
//                              "/api/employees"
//                             
//                              
//                      ).permitAll()
//                      .anyRequest().authenticated()
//              );
//
//      return http.build();
//  }
//}
    
    //open url
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
              .csrf(csrf -> csrf.disable())
              .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
      return http.build();
  }
  }

