package com.heartforecast.domain.oauth.service.dto;

public interface OAuth2Response {

    String getProvider();

    String getProviderId();

    String getEmail();

    String getName();
}
