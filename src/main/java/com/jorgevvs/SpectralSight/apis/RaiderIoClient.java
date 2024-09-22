package com.jorgevvs.SpectralSight.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "raiderIoClient", url = "https://raider.io/api/v1")
public interface RaiderIoClient {

    @GetMapping("/characters/profile?region={region}&realm={realm}&name={name}")
    String getCharacterProfile(@PathVariable("region") String region,
                               @PathVariable("realm") String realm,
                               @PathVariable("name") String name);
}
