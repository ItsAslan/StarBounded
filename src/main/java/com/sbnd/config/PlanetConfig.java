package com.sbnd.config;

import net.minecraftforge.common.config.Configuration;

public class PlanetConfig {

    public static int EARTH = 0;

    public static int MERCURY = 2;
    public static int VENUS = 3;
    public static int MOON = 4;
    public static int MARS = 5;
    public static int PHOBOS = 6;
    public static int DEIMOS = 7;
    public static int JUPITER = 8;
    public static int EUROPA = 9;
    public static int IO = 10;
    public static int SATURN = 11;
    public static int TITAN = 12;
    public static int URANUS = 13;
    public static int NEPTUNE = 14;
    public static int TRITON = 15;
    public static int PLUTO = 16;

    public static void loadFromConfig(Configuration config) {

        final String CATEGORY_PLANET_IDS = SbndConfig.CATEGORY_PLANET_IDS;

        EARTH = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.01_earth_id", "I wouldn't suggest changing this one. But hey, you do you", 0);

        MERCURY = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.02_mercury_id", "Dimension id for MERCURY", 2);
        VENUS = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.03_venus_id", "Dimension id for VENUS", 3);
        MOON = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.04_moon_id", "Dimension id for MOON", 4);
        MARS = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.05_mars_id", "Dimension id for MARS", 5);
        PHOBOS = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.06_phobos_id", "Dimension id for PHOBOS", 6);
        DEIMOS = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.07_deimos_id", "Dimension id for DEIMOS", 7);
        JUPITER = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.08_jupiter_id", "Dimension id for JUPITER", 8);
        EUROPA = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.09_europa_id", "Dimension id for EUROPA", 9);
        IO = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.10_io_id", "Dimension id for IO", 10);
        SATURN = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.11_saturn_id", "Dimension id for SATURN", 11);
        TITAN = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.12_titan_id", "Dimension id for TITAN", 12);
        URANUS = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.13_uranus_id", "Dimension id for URANUS", 13);
        NEPTUNE = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.14_neptune_id", "Dimension id for NEPTUNE", 14);
        TRITON = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.15_triton_id", "Dimension id for TRITON", 15);
        PLUTO = SbndConfig.createConfigInt(config, CATEGORY_PLANET_IDS, "1.16_pluto_id", "Dimension id for PLUTO", 16);

    }

}
