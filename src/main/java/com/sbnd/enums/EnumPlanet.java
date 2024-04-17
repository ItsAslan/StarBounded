package com.sbnd.enums;

import net.minecraft.util.EnumChatFormatting;

public enum EnumPlanet
{
    EARTH(EnumChatFormatting.DARK_GREEN, "Earth"),
    MOON(EnumChatFormatting.DARK_GRAY, "the Moon");

    public EnumChatFormatting color;
    private String name;

    EnumPlanet(EnumChatFormatting color, String name)
    {
        this.color = color;
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}
