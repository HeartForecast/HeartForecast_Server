package com.heartForecast.common.jwt.util;

import com.heartForecast.domain.auth.service.dto.CustomUserDetails;
import com.heartForecast.domain.oauth.service.dto.CustomOAuth2User;
import com.heartForecast.domain.user.domain.value.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthenticationUtil {


    public static Long getMemberId() {
        var anonymous = String.valueOf(isAnonymous());
        log.warn(anonymous);
        if (isAnonymous()) {
            return null;
        }
        return (Long) getAuthentication().getPrincipal();
    }


    public static Role getMemberRole() {
        if (isAnonymous()) {
            log.info("Anonymous user detected");
            return Role.GUEST;
        }

        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            return extractRoleFromAuthorities(authentication.getAuthorities());
        } else if (principal instanceof CustomOAuth2User oAuth2User) {
          return extractRoleFromAuthorities(oAuth2User.getAuthorities());
        }

        return extractRoleFromAuthorities(authentication.getAuthorities());
    }

    public static String getEmail() {
        Authentication authentication = getAuthentication();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        return principal.getEmail();
    }

    private static Role extractRoleFromAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .map(Role::valueOf)
                .findFirst()
                .orElse(Role.GUEST);
    }

    public static boolean isAnonymous() {
        Authentication authentication = getAuthentication();
        return authentication == null || authentication.getPrincipal().equals("anonymousUser");
    }


    private static Authentication getAuthentication() {
        var context = SecurityContextHolder.getContext();
        log.info("Context :"+ context);
        var result = context.getAuthentication();
        log.info("result : " + result);
        return result;
    }
}