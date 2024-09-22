package com.jorgevvs.SpectralSight.services;

import com.jorgevvs.SpectralSight.apis.RaiderIoClient;
import com.jorgevvs.SpectralSight.apis.WorldOfWarcraftAPI;
import org.springframework.stereotype.Service;

@Service
public class WorldOfWarcraftAPIService {
    private final WorldOfWarcraftAPI wowAPI;
    private final WowOAuthAcessTokenService wowAuth;

    public WorldOfWarcraftAPIService(WorldOfWarcraftAPI wowAPI, WowOAuthAcessTokenService wowAuth) {
        this.wowAPI = wowAPI;
        this.wowAuth = wowAuth;
    }

    public String getCharacterDungeons(String realm, String name) {
        return wowAPI.getCharacterDungeons(realm, name, "profile-us", "en-US", wowAuth.getNewToken());
    }
}