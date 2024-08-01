package com.sbnd.world.celestial;


import com.sbnd.main.ResourceManager;
import com.sbnd.world.celestial.core.CelestialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

@Getter
@AllArgsConstructor
public enum EnumCelestial {

    MOON(EnumChatFormatting.GRAY, ResourceManager.MOON, CelestialType.SATELLITE),

    EARTH(EnumChatFormatting.DARK_GREEN, ResourceManager.EARTH, CelestialType.PLANET),

    SOL(EnumChatFormatting.RED, ResourceManager.YELLOW_STAR, CelestialType.STAR); // This class is being deleted soon anyway

    private final EnumChatFormatting color;

    private final ResourceLocation icon;

    private final CelestialType type;

    // NullPointerException is my biggest op
    public static EnumCelestial NONE;

}
