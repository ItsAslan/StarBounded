package com.sbnd.world.celestial.core;

import lombok.Getter;

import java.util.Set;

@Getter
public class CelestialBody {

    private final ICelestialBodyData data;

    private final String name;

    private final CelestialType type;

    public CelestialBody(Set<CelestialBody> registry, ICelestialBodyData data, CelestialType type, String name) {

        this.data = data;
        this.name = name;
        this.type = type;

        registry.add(this);

    }

}
