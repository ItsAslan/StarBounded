package com.sbnd.world.celestial.core;

import com.sbnd.world.celestial.EnumCelestial;
import lombok.Getter;

import java.util.Set;

@Getter
public class CelestialBody {

    private final ICelestialBodyData data;

    private final String name;

    private final CelestialType type;

    private EnumCelestial parent = EnumCelestial.NONE;

    private EnumCelestial star = EnumCelestial.NONE;

    public CelestialBody(Set<CelestialBody> registry, ICelestialBodyData data, CelestialType type, String name) {

        this.data = data;
        this.name = name;
        this.type = type;

        registry.add(this);

    }

    public CelestialBody setParent(EnumCelestial parent) {

        this.parent = parent;
        return this;
    }

    public CelestialBody setStar(EnumCelestial star) {

        this.star = star;
        return this;

    }

}
