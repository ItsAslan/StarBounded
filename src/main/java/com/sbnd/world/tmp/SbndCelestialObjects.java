package com.sbnd.world.tmp;

import com.sbnd.config.PlanetConfig;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import com.sbnd.world.tmp.core.bodies.Star;
import com.sbnd.world.tmp.core.bodies.StarSystem;
import com.sbnd.world.tmp.core.EnumCelestialType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

import static com.sbnd.world.tmp.core.CelestialProperty.*;
import static com.sbnd.world.tmp.SbndGas.*;
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

        // This is a sample. Change `WorldProvider` to a custom one
        // initDimensions(WorldProvider.class , CelestialBody.getBody("Moon").getDimensionId());

    }

    public static void initDimensions(Class<? extends WorldProvider> c, int id) {

        DimensionManager.registerProviderType(id, c, false);
        DimensionManager.registerDimension(id, id);

    }

    public static void initSystems() {

        solarSystem = new StarSystem()

                .setName("Solar System")
                .setSizeAu(200_000)
                .addPrimaryGas(HELIUM, HYDROGEN)
                .setStar(new Star()

                        .setName("Sol")
                        .setRadiusKm(696_000)
                        .setTemperatureK(5_800)
                        .addPlanets(new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mercury")
                                        .setMassKg(3.3e23)
                                        .setRadiusKm(2_440)
                                        .setOrbitRadiusKm(57.9e6)
                                        .addProperties(HOT)
                                        .setDimensionId(PlanetConfig.EARTH),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Venus")
                                        .setFormatColor(YELLOW)
                                        .setMassKg(4.8e24)
                                        .setRadiusKm(6_052)
                                        .setOrbitRadiusKm(108.2e6)
                                        .addProperties(HOT, GREENHOUSE)
                                        .setDimensionId(PlanetConfig.VENUS),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Earth")
                                        .setMassKg(5.9e24)
                                        .setRadiusKm(6_378)
                                        .setOrbitRadiusKm(149.6e6)
                                        .addProperties(BREATHABLE)
                                        .addPrimaryGas(NITROGEN, OXYGEN)
                                        .setDimensionId(PlanetConfig.EARTH)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Moon")
                                                .setFormatColor(GRAY)
                                                .setMassKg(7.3e22)
                                                .setRadiusKm(1_079)
                                                .setOrbitRadiusKm(384_400)
                                                .setDimensionId(PlanetConfig.MOON)

                                        ),

                                new CelestialBody(EnumCelestialType.PLANET)

                                        .setName("Mars")
                                        .setFormatColor(RED)
                                        .setMassKg(6.3e23)
                                        .setRadiusKm(2_106)
                                        .setOrbitRadiusKm(228e6)
                                        .addPrimaryGas(CO2, NITROGEN, ARGON)
                                        .setDimensionId(PlanetConfig.MARS)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Phobos")
                                                        .setMassKg(1.06e16)
                                                        .setRadiusKm(11.1)
                                                        .setOrbitRadiusKm(6_000)
                                                        .setDimensionId(PlanetConfig.PHOBOS),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Deimos")
                                                        .setMassKg(1.5e15)
                                                        .setRadiusKm(6.2)
                                                        .setOrbitRadiusKm(23_458)
                                                        .setDimensionId(PlanetConfig.DEIMOS)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Jupiter")
                                        .setMassKg(1.8e27)
                                        .setRadiusKm(69_911)
                                        .setOrbitRadiusKm(778.5e6)
                                        .addPrimaryGas(HYDROGEN, HELIUM)
                                        .setDimensionId(PlanetConfig.JUPITER)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Europa")
                                                        .setMassKg(4.8e22)
                                                        .setRadiusKm(1_560)
                                                        .setOrbitRadiusKm(671_000)
                                                        .setDimensionId(PlanetConfig.EUROPA),

                                                new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Io")
                                                        .setMassKg(8.9e22)
                                                        .setRadiusKm(1_821)
                                                        .setOrbitRadiusKm(422_000)
                                                        .setDimensionId(PlanetConfig.IO)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Saturn")
                                        .setMassKg(5.6e26)
                                        .setRadiusKm(58.232)
                                        .setOrbitRadiusKm(1432e6)
                                        .addPrimaryGas(HYDROGEN, HELIUM)
                                        .setDimensionId(PlanetConfig.SATURN)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                        .setName("Titan")
                                                        .setMassKg(1.3e23)
                                                        .setRadiusKm(2_575)
                                                        .setOrbitRadiusKm(1.2e6)
                                                        .setDimensionId(PlanetConfig.TITAN)

                                        ),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Uranus")
                                        .setMassKg(8.7e25)
                                        .setRadiusKm(25_559)
                                        .setOrbitRadiusKm(2867e6)
                                        .addPrimaryGas(HYDROGEN, HELIUM)
                                        .setDimensionId(PlanetConfig.URANUS),

                                new CelestialBody(EnumCelestialType.GAS_GIANT)

                                        .setName("Neptune")
                                        .setMassKg(1.02e26)
                                        .setRadiusKm(24_622)
                                        .setOrbitRadiusKm(4515e6)
                                        .addPrimaryGas(HYDROGEN, HELIUM, METHANE)
                                        .setDimensionId(PlanetConfig.NEPTUNE)
                                        .addSatellites(new CelestialBody(EnumCelestialType.SATELLITE)

                                                .setName("Triton")
                                                .setMassKg(2.1e22)
                                                .setRadiusKm(2_706)
                                                .setOrbitRadiusKm(354_800)
                                                .setDimensionId(PlanetConfig.TRITON)

                                        ),

                                new CelestialBody(EnumCelestialType.DWARF)

                                        .setName("Pluto")
                                        .setMassKg(1.3e22)
                                        .setRadiusKm(1_188)
                                        .setOrbitRadiusKm(5906e6)
                                        .addProperties(FREEZING)
                                        .setDimensionId(PlanetConfig.PLUTO)

                                )

                );

    }

}
