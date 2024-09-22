package com.jorgevvs.SpectralSight.controllers;

import com.jorgevvs.SpectralSight.services.RaiderIoService;
import com.jorgevvs.SpectralSight.services.WorldOfWarcraftAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaiderIoController {

    private final RaiderIoService raiderIoService;
    private final WorldOfWarcraftAPIService wowService;

    public RaiderIoController(RaiderIoService raiderIoService, WorldOfWarcraftAPIService wowService) {
        this.raiderIoService = raiderIoService;
        this.wowService = wowService;
    }

    @GetMapping("/api/wow/character/{region}/{realm}/{name}")
    public String getCharacter(@PathVariable String region,
                               @PathVariable String realm,
                               @PathVariable String name) {
        return raiderIoService.getCharacterProfile(region, realm, name);
    }

    @GetMapping("/api/wow/character/{realm}/{name}")
    public String getCharacterDungeons( @PathVariable String realm,
                                        @PathVariable String name) {
        return wowService.getCharacterDungeons(realm, name);
    }
}
