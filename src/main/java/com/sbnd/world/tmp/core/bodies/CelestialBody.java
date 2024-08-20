package com.sbnd.world.tmp.core.bodies;

import com.sbnd.main.SbndUtil;
import com.sbnd.world.tmp.SbndCelestialObjects;
import com.sbnd.world.tmp.SbndGas;
import com.sbnd.world.tmp.core.CelestialProperty;
import com.sbnd.world.tmp.core.EnumCelestialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import java.util.*;

@Accessors(chain = true)
public class CelestialBody {

    // Basic Information

    @Getter
    private final EnumCelestialType type;

    @Getter
    private String name;

    public CelestialBody setName(String name) {

        this.name = name;

        CelestialBody.getNameToBodyMap().put(name, this);

        return this;

    }

    public CelestialBody(EnumCelestialType type) {

        this.type = type;

    }

    @Getter
    private int dimensionId;

    public CelestialBody setDimensionId(int id) {

        CelestialBody.getIdToBodyMap().put(id, this);

        this.dimensionId = id;

        return this;

    }

    @Setter
    @Getter
    private double massKg;

    @Setter
    @Getter
    private double radiusKm;

    @Getter
    public Map<String, CelestialBody> nameToSatelliteMap = new HashMap<>();
    @Getter
    public Set<CelestialBody> satellites = new HashSet<>();

    public CelestialBody addSatellites(CelestialBody... bodies) {

        Arrays.asList(bodies).forEach(e -> {

            e.setParent(this);
            nameToSatelliteMap.put(e.getName(), e);
            satellites.add(e);

        });

        return this;

    }

    @Setter
    @Getter
    public Star star;

    // Star map and Sky

    @Setter
    @Getter
    private double orbitRadiusKm; // When the body is a satellite, it means the distance away from the parent planet. When the body is anything else, it's the distance away from the star. I should probably change this but it's fine

    @Setter
    @Getter
    private float axialTiltDegrees;

    @Setter
    @Getter
    private float dayLengthSeconds;

    @Setter
    @Getter
    private boolean isTidallyLocked;

    // Kepler's Third Law
    public double getOrbitalPeriodSeconds() {

        double period = Math.sqrt((4 * Math.pow(Math.PI, 2) / SbndUtil.GRAVITATIONAL_CONSTANT * (massKg + parent.getMassKg())) * Math.pow(orbitRadiusKm, 3));

        return period / SbndUtil.SECONDS_MC_DAY;

    }

    public float getRotationalPeriod() {

        return 0;

    }

    @Setter
    @Getter
    private CelestialBody parent = null;

    @Setter
    @Getter
    private boolean visibleStars;

    @Setter
    @Getter
    private ResourceLocation icon;

    // Atmosphere

    @Getter
    private ArrayList<SbndGas> primaryGas = new ArrayList<>();

    public CelestialBody addPrimaryGas(SbndGas... gases) {

        primaryGas.addAll(Arrays.asList(gases));

        return this;

    }

    @Setter
    private int pressurePsi;

    @Getter
    public ArrayList<CelestialProperty> propertyList = new ArrayList<>();

    public CelestialBody addProperties(CelestialProperty... properties) {

        propertyList.addAll(Arrays.asList(properties));

        return this;

    }

    // Util

    @Setter
    @Getter
    private EnumChatFormatting formatColor;

    // Statics

    @Getter
    public static Map<String, CelestialBody> nameToBodyMap = new HashMap<>();

    @Getter
    public static Map<Integer, CelestialBody> idToBodyMap = new HashMap<>();

    public static CelestialBody getBody(String name) {

        return nameToBodyMap.get(name);

    }

    public static CelestialBody getBody(int id) {

        return idToBodyMap.get(id);

    }

}
