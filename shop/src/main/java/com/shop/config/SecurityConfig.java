package com.shop.config;

import com.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  MemberService memberService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.formLogin(form -> form
            .loginPage("/members/login")
            .defaultSuccessUrl("/", true)
            .failureUrl("/members/login/error")
            .usernameParameter("email")
            .passwordParameter("password")  // password 단어만 가능
            .permitAll());

    http.authorizeHttpRequests(request -> request
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/", "/members/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated());   // 나머지 경로는 인증을 받아야 함.

    http.logout(Customizer.withDefaults());

    http.exceptionHandling(exception -> exception
            .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder()   {
    return new BCryptPasswordEncoder();
  }
}
