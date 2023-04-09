package com.example.service.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
  private static final Logger LOGGER = LoggerFactory.getLogger(OAuthController.class);

  @GetMapping("/login/success")
  public String welcome() {
    LOGGER.info("After Login Success!");
    return "Welcome to Google !!";
  }

  @GetMapping("/user")
  public Principal user(Principal principal) {
    OAuth2User oAuth2User = ((OAuth2AuthenticationToken) principal).getPrincipal();
    LOGGER.info("username: {}", (String) oAuth2User.getAttribute("email"));
    return principal;
  }
}
