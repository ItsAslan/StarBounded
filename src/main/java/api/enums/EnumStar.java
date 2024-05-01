package api.enums;

import com.sbnd.main.ResourceManager;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public enum EnumStar
{
    SOL(EnumChatFormatting.GOLD, ResourceManager.SUN, "Sun", 0);

    private EnumChatFormatting color;
    private ResourceLocation texture;
    private String name;
    private int Id;

    EnumStar(EnumChatFormatting color, ResourceLocation texture, String name, int Id)
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
