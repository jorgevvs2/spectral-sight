package com.jorgevvs.SpectralSight.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "worldofwarcraftapi", url = "https://us.api.blizzard.com")
public interface WorldOfWarcraftAPI {
    @GetMapping("/profile/wow/character/{realmSlug}/{characterName}")
    String getCharacterDungeons(@PathVariable("realmSlug") String region,
                                @PathVariable("characterName") String realm,
                                @RequestParam("namespace") String namespace,
                                @RequestParam("locale") String locale,
                                @RequestParam("access_token") String accessToken);
}
