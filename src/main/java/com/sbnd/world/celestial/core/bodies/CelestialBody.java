package com.sbnd.world.celestial.core.bodies;

import com.sbnd.main.SbndUtil;
import com.sbnd.world.celestial.core.EnumCelestialType;
import com.sbnd.world.celestial.core.property.CelestialProperty;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class CelestialBody {

    @Getter private String name;
    @Getter private int id;

    @Getter private double massKg;
    @Getter private double radiusKm;
    @Getter private double orbitRadiusStarKm;
    @Getter private double orbitRadiusParentKm;
    @Getter private double axialTiltDegrees;
    @Getter private double rotationalPeriodSeconds;
    @Getter private boolean isTidallyLocked;

    private HashMap<String, CelestialBody> nameToSatelliteMap;
    private HashMap<Class<? extends CelestialProperty>, CelestialProperty> propertyList;

    @Getter private Star star;
    @Getter private CelestialBody parent;

    @Getter private ResourceLocation icon;
    @Getter private EnumChatFormatting formatColor;

    @Getter private EnumCelestialType type;

    public CelestialBody(EnumCelestialType _type) {

        type = _type;

        nameToSatelliteMap = new HashMap<>();
        propertyList = new HashMap<>();

    }

    //-----------------------CHAIN-----------------------//

    public CelestialBody setIcon(ResourceLocation _icon) {

        icon = _icon;

        return this;

    }

    public CelestialBody setColor(EnumChatFormatting _formatColor) {

        formatColor = _formatColor;

        return this;

    }

    public CelestialBody setName(String _name) {

        name = _name;

        CelestialBody.nameToBodyMap.put(name, this);

        return this;

    }

    public CelestialBody setId(int _id) {

        id = _id;

        CelestialBody.idToBodyMap.put(id, this);

        return this;

    }

    public CelestialBody setStar(Star _star) {

        star = _star;

        return this;

    }

    public CelestialBody setParent(CelestialBody _parent) {

        parent = _parent;

        return this;

    }

    public CelestialBody setMassKg(double _massKg) {

        massKg = _massKg;

        return this;

    }

    public CelestialBody setRadiusKm(double _radiusKm) {

        radiusKm = _radiusKm;

        return this;

    }

    public CelestialBody setOrbitRadiusStarKm(double _orbitRadiusStarKm) {

        orbitRadiusStarKm = _orbitRadiusStarKm;

        return this;

    }

    public CelestialBody setOrbitRadiusParentKm(double _orbitRadiusParentKm) {

        orbitRadiusParentKm = _orbitRadiusParentKm;

        return this;

    }

    public CelestialBody setAxialTiltDegrees(double _axialTiltDegrees) {

        axialTiltDegrees = _axialTiltDegrees;

        return this;

    }

    public CelestialBody setRotationalPeriodSeconds(double _rotationalPeriodSeconds) {

        rotationalPeriodSeconds = _rotationalPeriodSeconds;

        return this;

    }

    public CelestialBody setTidallyLocked() {

        isTidallyLocked = true;

        return this;

    }

    public CelestialBody addSatellite(CelestialBody... bodies) {

        Arrays.asList(bodies).forEach(body -> {

            body.setParent(this);
            nameToSatelliteMap.put(body.getName(), body);

        });

        return this;

    }

    //-----------------------PROPERTY-----------------------//

    public CelestialBody addProperty(CelestialProperty... properties) {

        Arrays.asList(properties).forEach(prop -> propertyList.put(prop.getClass(), prop));

        return this;

    }

    //-------------------------UTIL-------------------------//

    public double getOrbitalPeriodSeconds() {

        double orbitRadius = 0;

        switch(type) {

            case PLANET:

                orbitRadius = getOrbitRadiusStarKm();
                break;

            case SATELLITE:

                orbitRadius = getOrbitRadiusParentKm();
                break;

        }

        double period = Math.sqrt((4 * Math.pow(Math.PI, 2) / SbndUtil.GRAVITATIONAL_CONSTANT * (getMassKg() + getParent().getMassKg())) * Math.pow(orbitRadius, 3));

        return period / SbndUtil.SECONDS_MC_DAY;

    }

    public double getGravity() {

        double radius = radiusKm * 1000;

        return SbndUtil.GRAVITATIONAL_CONSTANT * massKg / (Math.pow(radius, 2));

    }

    public List<CelestialBody> getSatellites() {

        return new ArrayList<>(nameToSatelliteMap.values());

    }

    //------------------------STATIC------------------------//

    public static Map<String, CelestialBody> nameToBodyMap = new HashMap<>();

    public static Map<Integer, CelestialBody> idToBodyMap = new HashMap<>();

    public static CelestialBody getBody(String name) {

        return nameToBodyMap.get(name);

    }

    public static CelestialBody getBody(int id) {

        return idToBodyMap.get(id);

    }

}
