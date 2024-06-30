package com.sbnd.world.celestial.sample;


import com.sbnd.world.celestial.core.CelestialType;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public enum EnumCelestial {

    MOON(EnumChatFormatting.DARK_GREEN, null, CelestialType.SATELLITE),

    MARS(EnumChatFormatting.DARK_RED, null, CelestialType.PLANET),

    SOL(EnumChatFormatting.RED, null, CelestialType.STAR);

    @Getter
    private final EnumChatFormatting color;

    @Getter
    private final ResourceLocation icon;

    @Getter
    private final CelestialType type;

    EnumCelestial(EnumChatFormatting color, ResourceLocation icon, CelestialType type) {

        this.color = color;
        this.icon = icon;
        this.type = type;

    }

}
