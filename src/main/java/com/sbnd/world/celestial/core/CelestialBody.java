package com.sbnd.world.celestial.core;

import lombok.Getter;

public class CelestialBody {

    @Getter
    private final ICelestialBodyData data;

    @Getter
    private final String name;

    @Getter
    private final CelestialType type;

    public CelestialBody(ICelestialBodyData data, CelestialType type, String name) {

        this.data = data;
        this.name = name;
        this.type = type;

    }

}
