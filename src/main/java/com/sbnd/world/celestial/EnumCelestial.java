package com.sbnd.world.celestial;


import com.sbnd.main.ResourceManager;
import com.sbnd.world.celestial.core.CelestialType;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

@Getter
public enum EnumCelestial {

    MOON(EnumChatFormatting.GRAY, ResourceManager.MOON, CelestialType.SATELLITE),

    EARTH(EnumChatFormatting.DARK_GREEN, ResourceManager.EARTH, CelestialType.PLANET),

    SOL(EnumChatFormatting.RED, ResourceManager.SOL, CelestialType.STAR);

    private final EnumChatFormatting color;

    private final ResourceLocation icon;

    private final CelestialType type;

    EnumCelestial(EnumChatFormatting color, ResourceLocation icon, CelestialType type) {

        this.color = color;
        this.icon = icon;
        this.type = type;

    }

}
