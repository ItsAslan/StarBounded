package com.sbnd.world.tmp;

import com.sbnd.world.tmp.core.CelestialBody;
import com.sbnd.world.tmp.core.Star;
import com.sbnd.world.tmp.core.StarSystem;
import com.sbnd.world.tmp.core.enums.EnumCelestialType;

public class sbndCelestialObjects {

    // In system object you add star -> add planets -> add planet satellites in tree graph fashion
    // System
    //  -> Star (can be multiple) `setStar(Star... stars)`
    //      -> Planet
    //         -> Satellite
    //         -> Satellite
    //         -> Satellite
    //      -> Planet
    //         -> Satellite

    // You would make a `system` object which extends `StarSystem` and input all child data
    // within the class

    // This class is only used for registering systems
    // It will loop through every "dimension" inside the system and register it with a unique id
    // Each `CelestialBody` will be stored in the `CelestialBody` class through statics
    // They can be accessed via id or name -> CelestialBody.getBody(name / id)

    // This system supports binary star systems; however, it does not support binary star orbit deviation

    // Each `Planet` and `Satellite` object is an instance of the `CelestialBody` class
    // Meaning that upon instantiation of the planet / satellite, body data will have to be
    // input through method chaining. This includes the `WorldProvider` that must be registered
    // with and linked to the dimension

    // Each `CelestialBody` will include data about:
    // - External Properties (Mass, Orbit, Semi-major axis, etc...)
    // - Icon (2d and 3d)
    // - Atmospheric Properties

    // The `ChunkProvider` for each planet will extend a common `CelestialChunkProvider` that's
    // noise generation / structure generation can be altered to fit a planets certain criteria

    private static StarSystem solarSystem;

    public static void systemInit() {

        solarSystem = new StarSystem()

                .setName("Solar System")
                .setSizeAu(200_000)
                .setPrimaryGas(SbndGas.HELIUM, SbndGas.HYDROGEN)
                .setStar(new Star()

                        .setName("Sol")
                        .setRadiusKm(696_000)
                        .setTempuratureC(5_600)
                        .addPlanets(new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mercury")
                                        .setMassKg(3.3e23)
                                        .setRadiusKm(2_440)
                                        .setDimensionId(2),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Venus")
                                        .setMassKg(4.8e24)
                                        .setRadiusKm(6_052)
                                        .setDimensionId(3),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Earth")
                                        .setMassKg(5.9e24)
                                        .setRadiusKm(6_378)
                                        .setDimensionId(0)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Moon")
                                                .setMassKg(7.3e22)
                                                .setRadiusKm(1_079)
                                                .setDimensionId(4)

                                        ),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mars")
                                        .setMassKg(6.3e23)
                                        .setRadiusKm(2_106)
                                        .setDimensionId(5)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Phobos")
                                                        .setMassKg(1.06e16)
                                                        .setRadiusKm(11.1)
                                                        .setDimensionId(6),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Deimos")
                                                        .setMassKg(1.5e15)
                                                        .setRadiusKm(6.2)
                                                        .setDimensionId(7)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Jupiter")
                                        .setMassKg(1.8e27)
                                        .setRadiusKm(69_911)
                                        .setDimensionId(8)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Europa")
                                                        .setMassKg(4.8e22)
                                                        .setRadiusKm(1_560)
                                                        .setDimensionId(9),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Io")
                                                        .setMassKg(8.9e22)
                                                        .setRadiusKm(1_821)
                                                        .setDimensionId(10)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Saturn")
                                        .setMassKg(5.6e26)
                                        .setRadiusKm(58.232)
                                        .setDimensionId(11)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Titan")
                                                        .setMassKg(1.3e23)
                                                        .setRadiusKm(2_575)
                                                        .setDimensionId(12)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Uranus")
                                        .setMassKg(8.7e25)
                                        .setRadiusKm(25_559)
                                        .setDimensionId(13),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Neptune")
                                        .setMassKg(1.02e26)
                                        .setRadiusKm(24_622)
                                        .setDimensionId(14)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Triton")
                                                .setMassKg(2.1e22)
                                                .setRadiusKm(2_706)
                                                .setDimensionId(15)

                                        ),

                                new CelestialBody(EnumCelestialType.DWARF)

                                        .setName("Pluto")
                                        .setMassKg(1.3e22)
                                        .setRadiusKm(1_188)
                                        .setDimensionId(16)

                                )

                );

    }

}
