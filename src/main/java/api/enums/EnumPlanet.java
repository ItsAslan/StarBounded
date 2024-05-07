package api.enums;

import com.sbnd.main.ResourceManager;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public enum EnumPlanet
{
    EARTH(EnumChatFormatting.DARK_GREEN, ResourceManager.EARTH, "Earth", 0),
    MOON(EnumChatFormatting.DARK_GRAY, ResourceManager.MOON, "The Moon",2),
    MARS(EnumChatFormatting.DARK_RED, ResourceManager.MARS, "Mars", 3),
    MERCURY(EnumChatFormatting.GRAY, ResourceManager.MOON, "Mercury", 4),
    VENUS(EnumChatFormatting.YELLOW, ResourceManager.MOON, "Venus", 5);

    private EnumChatFormatting color;
    private ResourceLocation texture;
    private String name;
    private int Id;

    EnumPlanet(EnumChatFormatting color, ResourceLocation texture, String name, int Id)
    {
        this.color = color;
        this.texture = texture;
        this.name = name;
        this.Id = Id;
    }

    public String getName()
    {
        return this.name;
    }

    public ResourceLocation getTexture()
    {
        return this.texture;
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
