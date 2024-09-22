package com.jorgevvs.SpectralSight.apis;

import com.jorgevvs.SpectralSight.domain.entity.AccessToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wowoauthapi", url = "https://oauth.battle.net")
public interface WowOAuthAPI {
    @PostMapping("/token")
    AccessToken getAuthToken(@RequestParam("grant_type") String grantType,
                             @RequestHeader("Authorization") String authorization);
}