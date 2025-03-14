package com.prac.api_gateway.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;

import com.prac.api_gateway.models.AuthResponse;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
        @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient,
        @AuthenticationPrincipal OidcUser user,
        Model model) {
          logger.info("User logged in: " + user.getEmail());
          AuthResponse response = new AuthResponse();
          response.setUserId(user.getEmail());
          response.setAccessToken(authorizedClient.getAccessToken().getTokenValue());
          response.setRefreshToken(authorizedClient.getRefreshToken().getTokenValue());
            response.setAuthorities(user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
            response.setExpiresAt(Optional.of(authorizedClient.getAccessToken().getExpiresAt().getEpochSecond()));
            return ResponseEntity.ok(response);



        }

        }

        
