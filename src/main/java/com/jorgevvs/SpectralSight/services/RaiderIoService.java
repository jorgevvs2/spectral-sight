package com.jorgevvs.SpectralSight.services;

import com.jorgevvs.SpectralSight.apis.RaiderIoClient;
import org.springframework.stereotype.Service;

@Service
public class RaiderIoService {
    private final RaiderIoClient raiderIoClient;

    public RaiderIoService(RaiderIoClient raiderIoClient) {
        this.raiderIoClient = raiderIoClient;
    }

    public String getCharacterProfile(String region, String realm, String name) {
        return raiderIoClient.getCharacterProfile(region, realm, name);
    }
}
