package com.heartForecast.domain.oauth.service;

import com.heartForecast.domain.oauth.exception.SocialUserExistedException;
import com.heartForecast.domain.oauth.service.dto.*;
import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.domain.repository.UserRepository;
import com.heartForecast.domain.user.domain.value.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response;
      log.warn("오어스 서비스 registrationId : {}", registrationId);

      switch (registrationId) {
        case "google" -> oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        case "naver" -> oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        case "kakao" -> oAuth2Response = new KakaoResponse(oAuth2User.getAttributes());
        default -> {
          return null;
        }
      }

      log.warn("오어스 서비스 oAuth2Response : {}", oAuth2Response);
        String type = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();

        Users existData = userRepository.findByEmail(oAuth2Response.getEmail());
        Role role;
        Long id;
        String username = oAuth2Response.getName();

        if (existData == null) {
            Users users = Users.socialUserBuilder()
                .email(oAuth2Response.getEmail())
                .username(username)
                .type(type)
                .role(Role.GUEST)
                .build();

            userRepository.save(users);
            role = Role.GUEST;
            id = users.getId();
        } else {
            if (existData.getType().equals("normal")) {
                log.warn("이미 존재합니다.");
                throw new SocialUserExistedException();
            }

            existData.updateSocial(oAuth2Response.getEmail(), type);
            userRepository.save(existData);
            role = (existData.getRole() == Role.GUEST) ? Role.GUEST : existData.getRole();
            id = existData.getId();
            username = existData.getUsername();
        }

        UserDto userDto = UserDto.builder()
            .id(id)
            .role(role)
            .username(username)
            .build();
      log.warn("오어스 서비스 userDto : {}", userDto.toString());

        return new CustomOAuth2User(userDto);
    }
}
