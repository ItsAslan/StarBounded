package com.sbnd.world.tmp.core;

import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.util.ResourceLocation;

@Accessors(chain = true)
@Setter
public class StarSystem {

    private double sizeKm;
    private double travelDistanceKm;

    private ResourceLocation icon;

    private Star star;

    private String name;

    // Contains:
    // Star
    // Icon
    // Size
    // Location
    // Travel Distance
    // Primary Gas

}
