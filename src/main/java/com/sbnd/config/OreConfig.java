package com.sbnd.config;

import net.minecraftforge.common.config.Configuration;

public class OreConfig {

    public static int COPPER_SPAWN_RATE = 8;
    public static int ALUMINUM_SPAWN_RATE = 6;
    public static int TITANIUM_SPAWN_RATE = 6;
    public static int TUNGSTEN_SPAWN_RATE = 5;
    public static int TIN_SPAWN_RATE = 6;
    public static int SULFUR_SPAWN_RATE = 6;

    public static int ZIRCONIUM_SPAWN_RATE = 2;
    public static int NIOBIUM_SPAWN_RATE = 3;
    public static int TANTALUM_SPAWN_RATE = 7;

    public static void loadFromConfig(Configuration config) {

        final String CATEGORY_ORE_SPAWN = SbndConfig.CATEGORY_ORE_SPAWN;

        COPPER_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.01_copper_rate", "Spawn Rate for Copper Ore", 8);
        ALUMINUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.02_aluminum_rate", "Spawn Rate for Aluminum Ore", 6);
        TITANIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.03_titanium_rate", "Spawn Rate for Titanium Ore", 6);
        TUNGSTEN_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.04_tungsten_rate", "Spawn Rate for Tungsten Ore", 5);
        TIN_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.05_tin_rate", "Spawn Rate for Tin Ore", 6);
        SULFUR_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.06_sulfur_rate", "Spawn Rate for Sulfur Ore", 6);

        ZIRCONIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.07_zirconium_rate", "Spawn Rate for Zirconium Ore", 2);
        NIOBIUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.08_niobium_rate", "Spawn Rate for Niobium Ore", 3);
        TANTALUM_SPAWN_RATE = SbndConfig.createConfigInt(config, CATEGORY_ORE_SPAWN, "1.09_tantalum_rate", "Spawn Rate for Tantalum Ore", 7);

    }

}
