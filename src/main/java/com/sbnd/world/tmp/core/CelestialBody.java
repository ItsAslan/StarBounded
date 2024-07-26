package com.sbnd.world.tmp.core;

import com.sbnd.world.tmp.SbndGas;
import com.sbnd.world.tmp.core.enums.EnumCelestialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;

@Accessors(chain = true)
public class CelestialBody {

    // Basic Information

    @Getter
    private final EnumCelestialType type;

    @Setter
    private String name;

    public CelestialBody(EnumCelestialType type) {

        this.type = type;

    }

    @Getter
    @Setter
    private int dimensionId;

    @Setter
    private int mass;

    @Setter
    private int radius;

    public ArrayList<CelestialBody> satellites = new ArrayList<>();

    public CelestialBody addSatellites(CelestialBody... bodies) {

        satellites.addAll(Arrays.asList(bodies));

        return this;

    }

    // Star map and Sky

    @Setter
    private int orbitRadiusKm;

    @Setter
    private CelestialBody parent = null;

    @Setter
    private boolean visibleStars;

    // Atmosphere

    @Setter
    private int temperatureC;

    @Setter
    @Getter
    private SbndGas primaryAtmosphereGas;

    @Setter
    private int radiationRad;

    @Setter
    private int pressurePsi;

    public ArrayList<CelestialProperty> propertyList = new ArrayList<>();

    public CelestialBody addProperties(CelestialProperty... properties) {

        propertyList.addAll(Arrays.asList(properties));

        return this;

    }

}
