package com.backend.auth.config.security.oauth.service;

import com.backend.auth.config.security.oauth.OAuthAttributes;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OAuthAttributesConverter {
    OAuthAttributes convert(OAuth2UserRequest userRequest, OAuth2User oAuth2User);
}
