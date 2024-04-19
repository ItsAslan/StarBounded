package com.sbnd.enums;

import net.minecraft.util.EnumChatFormatting;

public enum EnumPlanet
{
    EARTH(EnumChatFormatting.DARK_GREEN, "Earth"),
    MOON(EnumChatFormatting.DARK_GRAY, "the Moon"),
    MARS(EnumChatFormatting.DARK_RED, "Mars");

    private EnumChatFormatting color;
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

    public EnumChatFormatting getColor()
    {
        return this.color;
    }

}
