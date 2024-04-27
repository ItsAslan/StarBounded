package com.sbnd.enums;

import net.minecraft.util.EnumChatFormatting;

public enum EnumPlanet
{
    EARTH(EnumChatFormatting.DARK_GREEN, "Earth", 0),
    MOON(EnumChatFormatting.DARK_GRAY, "the Moon",2),
    MARS(EnumChatFormatting.DARK_RED, "Mars", 3);

    private EnumChatFormatting color;
    private String name;
    private int Id;

    EnumPlanet(EnumChatFormatting color, String name, int Id)
    {
        this.color = color;
        this.name = name;
        this.Id = Id;
    }

    public String getName()
    {
        return this.name;
    }

    public EnumChatFormatting getColor()
    {
        return this.color;
    }

    public int getDimensionId()
    {
        return this.Id;
    }

}
