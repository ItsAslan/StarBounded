package com.sbnd.world.tmp.core.bodies;

import com.sbnd.main.ResourceManager;
import com.sbnd.world.tmp.SbndGas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.util.ResourceLocation;

import java.util.*;

@Accessors(chain = true)
public class Star {

    @Getter
    private StarColor color;

    private void calculateStarColor() {

        color = getColorForTemp(temperatureK);

    }

    private StarColor getColorForTemp(int temp) {

        return Arrays.stream(StarColor.values())
                .filter(color -> temp >= color.getMinTemp() && temp <= color.getMaxTemp())
                .findFirst()
                .orElse(null);

    }

    public ResourceLocation getStarIcon() {

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

    @AllArgsConstructor
    @Getter
    private enum StarColor {

        BLUE(         'O',  30_000,  Integer.MAX_VALUE),
        BLUE_WHITE(   'B',  10_000,  30_000),
        WHITE(        'A',  7_500,   10_000),
        YELLOW_WHITE( 'F',  6_000,   7_500),
        YELLOW(       'G',  5_200,   6_000),
        ORANGE(       'K',  3_700,   5_200),
        RED(          'M',  2_400,   3_700);

        private final char starClass;

        private final int minTemp;
        private final int maxTemp;

    }

    private ResourceLocation blue() { return ResourceManager.BLUE_STAR; }
    private ResourceLocation blueWhite() { return ResourceManager.BLUE_WHITE_STAR; }
    private ResourceLocation white() { return ResourceManager.WHITE_STAR; }
    private ResourceLocation yellowWhite() { return ResourceManager.YELLOW_WHITE_STAR; }
    private ResourceLocation yellow() { return ResourceManager.YELLOW_STAR; }
    private ResourceLocation orange() { return ResourceManager.ORANGE_STAR; }
    private ResourceLocation red() { return ResourceManager.RED_STAR; }

    @Getter
    private int temperatureK;

    public Star setTemperatureK(int temp) {

        temperatureK = temp;
        calculateStarColor();

        return this;

    }

    @Setter
    @Getter
    private double radiusKm;

    @Setter
    private String name;

    @Getter
    private ArrayList<SbndGas> primaryGas;

    public Star setPrimaryGas(SbndGas... gases) {

        primaryGas.addAll(Arrays.asList(gases));

        return this;

    }

    @Getter
    public ArrayList<CelestialBody> planets = new ArrayList<>();

    public Star addPlanets(CelestialBody... bodies) {

        Arrays.asList(bodies).forEach(e -> e.setStar(this));

        planets.addAll(Arrays.asList(bodies));

        return this;

    }

}
