package com.sbnd.config;

import net.minecraftforge.common.config.Configuration;

public class OreConfig {

    public static int COPPER_SPAWN_RATE = 8;
    public static int ALUMINUM_SPAWN_RATE = 6;
    public static int TITANIUM_SPAWN_RATE = 6;
    public static int TUNGSTEN_SPAWN_RATE = 5;
    public static int TIN_SPAWN_RATE = 6;
    public static int SULFUR_SPAWN_RATE = 6;
    public static int SALTPETER_SPAWN_RATE = 12;

    public static int ZIRCONIUM_SPAWN_RATE = 2;
    public static int NIOBIUM_SPAWN_RATE = 3;
    public static int TANTALUM_SPAWN_RATE = 7;
    public static int MOON_IRON_SPAWN_RATE = 14;
    public static int MOON_TIN_SPAWN_RATE = 12;
    public static int MOON_TITANIUM_SPAWN_RATE = 10;
    public static int MOON_ROCK_SALTPETER_SPAWN_RATE = 15;
    public static int MOON_BASALT_SALTPETER_SPAWN_RATE = 15;
    public static int ICE_IRON_SPAWN_RATE = 16;

    public static void loadFromConfig(Configuration config) {

        final String CATEGORY_ORE_SPAWN = SbndConfig.CATEGORY_ORE_SPAWN;

        COPPER_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.01_copper_rate", "Spawn Rate for Copper Ore", 8);
        ALUMINUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.02_aluminum_rate", "Spawn Rate for Aluminum Ore", 6);
        TITANIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.03_titanium_rate", "Spawn Rate for Titanium Ore", 6);
        TUNGSTEN_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.04_tungsten_rate", "Spawn Rate for Tungsten Ore", 5);
        TIN_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.05_tin_rate", "Spawn Rate for Tin Ore", 6);
        SULFUR_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.06_sulfur_rate", "Spawn Rate for Sulfur Ore", 6);
        SALTPETER_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.07_saltpeter_rate", "Spawn Rate for Saltpeter Ore", 12);

        ZIRCONIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.08_zirconium_rate", "Spawn Rate for Zirconium Ore", 2);
        NIOBIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.09_niobium_rate", "Spawn Rate for Niobium Ore", 3);
        TANTALUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.010_tantalum_rate", "Spawn Rate for Tantalum Ore", 7);
        MOON_IRON_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.011_moon_iron_rate", "Spawn Rate for Moon Iron Ore", 14);
        MOON_TIN_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.012_moon_tin_rate", "Spawn Rate for Moon Tin Ore", 12);
        MOON_TITANIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.013_moon_titanium_rate", "Spawn Rate for Moon Titanium Ore", 10);
        MOON_ROCK_SALTPETER_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.014_moon_rock_saltpeter_rate", "Spawn Rate for Moon Rock Saltpeter Ore", 15);
        MOON_BASALT_SALTPETER_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.015_moon_basalt_saltpeter_rate", "Spawn Rate for Moon Basalt Saltpeter Ore", 15);
        ICE_IRON_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.015_ice_iron_rate", "Spawn Rate for Ice Iron Ore", 16);

    }

}
