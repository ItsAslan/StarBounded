package com.sbnd.world.tmp.core.bodies;

import com.sbnd.world.tmp.SbndGas;
import com.sbnd.world.tmp.core.CelestialProperty;
import com.sbnd.world.tmp.core.EnumCelestialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)
public class CelestialBody {

    // Basic Information

    @Getter
    private final EnumCelestialType type;

    @Getter
    private String name;

    public CelestialBody setName(String name) {

        this.name = name;

        nameToBodyMap.put(name, this);

        return this;

    }

    public CelestialBody(EnumCelestialType type) {

        this.type = type;

    }

    @Getter
    private int dimensionId;

    public CelestialBody setDimensionId(int id) {

        idToBodyMap.put(id, this);

        this.dimensionId = id;

        return this;

    }

    @Setter
    private double massKg;

    @Setter
    private double radiusKm;

    @Getter
    public Map<String, CelestialBody> nameToSatelliteMap = new HashMap<>();

    public CelestialBody addSatellites(CelestialBody... bodies) {

        Arrays.asList(bodies).forEach(e -> {

            e.setParent(this);
            nameToSatelliteMap.put(e.getName(), e);

        });

        return this;

    }

    @Getter @Setter
    public Star star;

    // Star map and Sky

    @Setter
    private double orbitRadiusKm;

    @Setter
    private float axialTilt;

    @Setter
    private CelestialBody parent = null;

    @Setter
    private boolean visibleStars;

    @Getter
    private ResourceLocation icon;

    // Atmosphere

    @Setter
    @Getter
    private SbndGas primaryAtmosphereGas;

    @Setter
    private int pressurePsi;

    @Getter
    public ArrayList<CelestialProperty> propertyList = new ArrayList<>();

    public CelestialBody addProperties(CelestialProperty... properties) {

        propertyList.addAll(Arrays.asList(properties));

        return this;

    }

    // Statics

    public static Map<String, CelestialBody> nameToBodyMap;
    public static Map<Integer, CelestialBody> idToBodyMap;

    public static CelestialBody getBody(String name) {

        return nameToBodyMap.get(name);

    }

    public static CelestialBody getBody(int id) {

        return idToBodyMap.get(id);

    }

}
