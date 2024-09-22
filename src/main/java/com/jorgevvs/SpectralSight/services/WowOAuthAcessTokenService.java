package com.jorgevvs.SpectralSight.services;

import com.jorgevvs.SpectralSight.apis.WowOAuthAPI;
import com.jorgevvs.SpectralSight.domain.entity.AccessToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Getter
@Service
@PropertySource("classpath:application.properties")
public class WowOAuthAcessTokenService {

    private final WowOAuthAPI wowOAuthAPI;

    @Value("${wow.client.id}")
    private String clientId;

    @Value("${wow.client.secret}")
    private String clientSecret;


    public WowOAuthAcessTokenService(WowOAuthAPI wowAuthAPI) {
        this.wowOAuthAPI = wowAuthAPI;
    }

    public String getNewToken(){
        String auth = clientId + ":" + clientSecret;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
        AccessToken accessToken = wowOAuthAPI.getAuthToken("client_credentials", basicAuth);
        return accessToken.getAccessToken();
    }
}