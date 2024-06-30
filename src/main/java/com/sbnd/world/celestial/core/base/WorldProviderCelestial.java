package com.sbnd.world.celestial.core.base;

import com.sbnd.world.celestial.core.data.ISkyData;
import com.sbnd.world.celestial.core.data.IWorldData;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

@Getter
public class WorldProviderCelestial extends WorldProvider {

    private IWorldData worldData;
    private ISkyData skyData;

    public WorldProviderCelestial() {
        setCloudRenderer(new NoCloudRenderer());
    }

    @Override
    public String getDimensionName() {
        return getWorldData().getName();
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return getWorldData().getChunkProvider(worldObj);
    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return getSkyData().getSkyRenderer();
    }

    @Override
    public Vec3 getFogColor(float timeOfDay, float brightness) {

        int color = Integer.parseInt(getSkyData().getFogColor().substring(2), 16);

        // Extract the red, green, and blue components
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;

        return Vec3.createVectorHelper(r, g, b);

    }

    static class NoCloudRenderer extends IRenderHandler {

        @Override
        public void render(float partialTicks, WorldClient world, Minecraft mc) { }

    }

}