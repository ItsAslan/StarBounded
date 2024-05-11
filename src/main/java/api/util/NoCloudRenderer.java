package api.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.IRenderHandler;

public class NoCloudRenderer extends IRenderHandler
{

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) { }

}
