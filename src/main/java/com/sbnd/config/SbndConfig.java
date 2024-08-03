package com.sbnd.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class SbndConfig {

    //CATEGORY LIST
    public static final String CATEGORY_PLANET_IDS = "01_planet_ids";
    public static final String CATEGORY_ORE_SPAWN = "02_ore_spawn";

    public static String createConfigString(Configuration config, String category, String name, String comment, String value) {

        Property prop = config.get(category, name, value);

        prop.comment = comment;

        return prop.getString();

    }

    public static int createConfigInt(Configuration config, String category, String name, String comment, int value) {

        Property prop = config.get(category, name, value);

        prop.comment = comment;

        return prop.getInt();

    }

    public static double createConfigDouble(Configuration config, String category, String name, String comment, double value) {

        Property prop = config.get(category, name, value);

        prop.comment = comment;

        return prop.getDouble();

    }

    public static boolean createConfigBoolean(Configuration config, String category, String name, String comment, boolean value) {

        Property prop = config.get(category, name, value);

        prop.comment = comment;

        return prop.getBoolean();

    }

}
