package com.sbnd.world.tmp;

import com.sbnd.world.celestial.EnumCelestial;
import com.sbnd.world.celestial.core.CelestialType;
import com.sbnd.world.celestial.sample.moon.MoonBodyData;
import com.sbnd.world.tmp.core.CelestialBody;
import com.sbnd.world.tmp.core.Star;
import com.sbnd.world.tmp.core.StarSystem;
import com.sbnd.world.tmp.core.enums.EnumCelestialType;

import java.util.HashSet;
import java.util.Set;

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
                .setSizeKm(100)
                .setStar(new Star()

                        .setName("Sol")
                        .addPlanets(new CelestialBody(EnumCelestialType.PLANET)

                                .setName("Earth")
                                .setOrbitRadiusKm(15_000)
                                .setTemperatureC(90)
                                .setDimensionId(2)

                        )

                );

    }

}
