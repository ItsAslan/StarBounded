package com.sbnd.world.tmp.core.bodies;

import com.sbnd.world.tmp.SbndGas;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;

@Accessors(chain = true)
public class StarSystem {

    // Contains:
    // Star
    // Icon
    // Size
    // Location
    // Travel Distance
    // Primary Gas

    @Setter
    private double sizeAu;

    @Setter
    private double travelDistanceAu;

    @Setter
    private ResourceLocation icon;

    @Setter
    @Getter
    private Star star;

    @Setter
    private String name;

    @Getter
    private ArrayList<SbndGas> primaryGas = new ArrayList<>();

    public StarSystem addPrimaryGas(SbndGas... gases) {

        primaryGas.addAll(Arrays.asList(gases));

        return this;

    }

}
