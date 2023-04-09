package com.example.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  private final OidcUserServiceConfig oidcUserServiceConfig;

  @Autowired
  public SecurityConfig(OidcUserServiceConfig oidcUserServiceConfig) {
    this.oidcUserServiceConfig = oidcUserServiceConfig;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/api/login")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login(
            oauth ->
                oauth
                    .userInfoEndpoint(user -> user.oidcUserService(oidcUserServiceConfig))
                    .defaultSuccessUrl("https://localhost:8443/api/v1/login/success"));

    return http.build();
  }
}
