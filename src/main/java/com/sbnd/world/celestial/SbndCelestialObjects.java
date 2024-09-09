package com.sbnd.world.celestial;

import api.util.TimeUtil;
import com.sbnd.config.PlanetConfig;
import com.sbnd.main.ResourceManager;
import com.sbnd.world.celestial.bodies.mars.WorldProviderMars;
import com.sbnd.world.celestial.bodies.moon.WorldProviderMoon;
import com.sbnd.world.celestial.core.bodies.CelestialBody;
import com.sbnd.world.celestial.core.bodies.Star;
import com.sbnd.world.celestial.core.bodies.StarSystem;
import com.sbnd.world.celestial.core.EnumCelestialType;
import com.sbnd.world.celestial.core.gen.WorldProviderCelestial;
import net.minecraftforge.common.DimensionManager;

import static net.minecraft.util.EnumChatFormatting.*;

public class SbndCelestialObjects {

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

    // Stars are set for `CelestialBody`s in the `Star` class when they are added to the `planets`
    // ArrayList in the `Star` class

    // All `CelestialBody`s are added to two static maps-- `nameToBodyMap` and `idToBodyMap.`
    // These do what they say. Use `getBody(String name / int id)`

    private static StarSystem solarSystem;

    public static void REGISTER() {

        initSystems();

        initDimensions(WorldProviderMoon.class , CelestialBody.getBody("Moon").getId());
        initDimensions(WorldProviderMars.class, CelestialBody.getBody("Mars").getId());

    }

    public static void initDimensions(Class<? extends WorldProviderCelestial> c, int id) {

        DimensionManager.registerProviderType(id, c, false);
        DimensionManager.registerDimension(id, id);

    }

    private static void initSystems() {

        solarSystem = new StarSystem()

                .setName("Solar System")
                .setSizeAu(200_000)
                .setStar(new Star()

                        .setName("Sol")
                        .setRadiusKm(696_000)
                        .setTemperatureK(5_800)
                        .addPlanet(new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mercury")
                                        .setIcon(ResourceManager.MERCURY)
                                        .setMassKg(3.3e23)
                                        .setRadiusKm(2_440)
                                        .setOrbitRadiusStarKm(57.9e6)
                                        .setId(PlanetConfig.EARTH),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Venus")
                                        .setIcon(ResourceManager.VENUS)
                                        .setColor(YELLOW)
                                        .setMassKg(4.8e24)
                                        .setRadiusKm(6_052)
                                        .setOrbitRadiusStarKm(108.2e6)
                                        .setId(PlanetConfig.VENUS),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Earth")
                                        .setIcon(ResourceManager.EARTH)
                                        .setMassKg(5.9e24)
                                        .setRadiusKm(6_378)
                                        .setOrbitRadiusStarKm(149.6e6)
                                        .setId(PlanetConfig.EARTH)
                                        .addSatellite(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Moon")
                                                .setIcon(ResourceManager.MOON)
                                                .setColor(GRAY)
                                                .setMassKg(7.3e22)
                                                .setOrbitRadiusParentKm(1_079)
                                                .setOrbitRadiusParentKm(384_400)
                                                .setAxialTiltDegrees(5)
                                                .setRotationalPeriodSeconds(TimeUtil.DayToSecond(29.5F))
                                                .setId(PlanetConfig.MOON)

                                        ),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mars")
                                        .setIcon(ResourceManager.MARS)
                                        .setColor(RED)
                                        .setMassKg(6.3e23)
                                        .setRadiusKm(2_106)
                                        .setOrbitRadiusStarKm(228e6)
                                        .setId(PlanetConfig.MARS)
                                        .addSatellite(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Phobos")
                                                        .setMassKg(1.06e16)
                                                        .setRadiusKm(11.1)
                                                        .setOrbitRadiusParentKm(6_000)
                                                        .setId(PlanetConfig.PHOBOS),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Deimos")
                                                        .setMassKg(1.5e15)
                                                        .setRadiusKm(6.2)
                                                        .setOrbitRadiusParentKm(23_458)
                                                        .setId(PlanetConfig.DEIMOS)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Jupiter")
                                        .setMassKg(1.8e27)
                                        .setRadiusKm(69_911)
                                        .setOrbitRadiusStarKm(778.5e6)
                                        .setId(PlanetConfig.JUPITER)
                                        .addSatellite(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Europa")
                                                        .setMassKg(4.8e22)
                                                        .setRadiusKm(1_560)
                                                        .setOrbitRadiusParentKm(671_000)
                                                        .setId(PlanetConfig.EUROPA),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Io")
                                                        .setMassKg(8.9e22)
                                                        .setRadiusKm(1_821)
                                                        .setOrbitRadiusParentKm(422_000)
                                                        .setId(PlanetConfig.IO)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Saturn")
                                        .setMassKg(5.6e26)
                                        .setRadiusKm(58.232)
                                        .setOrbitRadiusStarKm(1432e6)
                                        .setId(PlanetConfig.SATURN)
                                        .addSatellite(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Titan")
                                                        .setMassKg(1.3e23)
                                                        .setRadiusKm(2_575)
                                                        .setOrbitRadiusParentKm(1.2e6)
                                                        .setId(PlanetConfig.TITAN)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Uranus")
                                        .setMassKg(8.7e25)
                                        .setRadiusKm(25_559)
                                        .setOrbitRadiusStarKm(2867e6)
                                        .setId(PlanetConfig.URANUS),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Neptune")
                                        .setMassKg(1.02e26)
                                        .setRadiusKm(24_622)
                                        .setOrbitRadiusStarKm(4515e6)
                                        .setId(PlanetConfig.NEPTUNE)
                                        .addSatellite(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Triton")
                                                .setMassKg(2.1e22)
                                                .setRadiusKm(2_706)
                                                .setOrbitRadiusParentKm(354_800)
                                                .setId(PlanetConfig.TRITON)

                                        ),

                                new CelestialBody(EnumCelestialType.DWARF)

                                        .setName("Pluto")
                                        .setMassKg(1.3e22)
                                        .setRadiusKm(1_188)
                                        .setOrbitRadiusStarKm(5906e6)
                                        .setId(PlanetConfig.PLUTO)

                                )

                );

    }

}
