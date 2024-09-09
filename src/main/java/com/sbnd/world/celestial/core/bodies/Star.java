package com.sbnd.world.celestial.core.bodies;

import com.sbnd.main.ResourceManager;
import com.sbnd.content.transport.fluid.gas.ModGasses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class Star {

    @Getter private String name;
    @Getter private double radiusKm;
    @Getter private int temperatureK;
    @Getter private StarColor color;

    @Getter private ArrayList<StarGas> gasses;
    @Getter private ArrayList<CelestialBody> planets = new ArrayList<>();

    public ResourceLocation getIcon() {

        switch(color) {

            case BLUE: return blue();

            case BLUE_WHITE: return blueWhite();

            case WHITE: return white();

            case YELLOW_WHITE: return yellowWhite();

            case YELLOW: return yellow();

            case ORANGE: return orange();

            case RED: return red();

        }

        return null;

    }

    //-----------------------CHAIN-----------------------//

    public Star setName(String _name) {

        name = _name;

        return this;

    }

    public Star setRadiusKm(double _radiusKm) {

        radiusKm = _radiusKm;

        return this;

    }

    public Star setTemperatureK(int _temperatureK) {

        calculateStarColor(_temperatureK);

        temperatureK = _temperatureK;

        return this;

    }

    public Star addGas(StarGas... _gasses) throws ArithmeticException {

        double totalPercentage = 0D;

        for(StarGas gas : _gasses) {

            totalPercentage += gas.getPercentage();

        }

        if(totalPercentage > 100D) {

            throw new ArithmeticException(String.format("Percentage is greater than 100: %f", totalPercentage));

        }

        gasses.addAll(Arrays.asList(_gasses));

        return this;

    }

    public Star addPlanet(CelestialBody... _planets) {

        for(CelestialBody planet : _planets) {

            setStarRecursive(planet);

        }

        planets.addAll(Arrays.asList(_planets));

        return this;

    }

    //-------------------------UTIL-------------------------//

    private void setStarRecursive(CelestialBody _body) {

        _body.setStar(this);

        if(_body.getSatellites().isEmpty()) return;

        for(CelestialBody satellite : _body.getSatellites()) {

            setStarRecursive(satellite);

        }

    }

    private void calculateStarColor(int _temperatureK) {

        color = getColorForTemp(_temperatureK);

    }

    private StarColor getColorForTemp(int temp) {

        return Arrays.stream(StarColor.values())
                .filter(color -> temp >= color.getMinTemp() && temp <= color.getMaxTemp())
                .findFirst()
                .orElse(null);

    }

    private ResourceLocation blue() { return ResourceManager.BLUE_STAR; }
    private ResourceLocation blueWhite() { return ResourceManager.BLUE_WHITE_STAR; }
    private ResourceLocation white() { return ResourceManager.WHITE_STAR; }
    private ResourceLocation yellowWhite() { return ResourceManager.YELLOW_WHITE_STAR; }
    private ResourceLocation yellow() { return ResourceManager.YELLOW_STAR; }
    private ResourceLocation orange() { return ResourceManager.ORANGE_STAR; }
    private ResourceLocation red() { return ResourceManager.RED_STAR; }

    //---------------------INNER CLASS---------------------//

    @AllArgsConstructor
    public static class StarGas {

        @Getter private ModGasses gas;
        @Getter private double percentage;

    }

    @AllArgsConstructor
    private enum StarColor {

        BLUE(         'O',  30_000D,  Integer.MAX_VALUE),
        BLUE_WHITE(   'B',  10_000D,  30_000D),
        WHITE(        'A',  7_500D,   10_000D),
        YELLOW_WHITE( 'F',  6_000D,   7_500D),
        YELLOW(       'G',  5_200D,   6_000D),
        ORANGE(       'K',  3_700D,   5_200D),
        RED(          'M',  2_400D,   3_700D);

        @Getter private final char starClass;

        @Getter private final double minTemp;
        @Getter private final double maxTemp;

    }

}
