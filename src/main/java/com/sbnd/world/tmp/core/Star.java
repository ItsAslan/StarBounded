package com.sbnd.world.tmp.core;

import com.sbnd.world.tmp.SbndGas;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;

@Accessors(chain = true)
public class Star {

    @Setter
    private double radiusKm;

    @Setter
    private int tempuratureC;

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

        planets.addAll(Arrays.asList(bodies));

        return this;

    }

}
