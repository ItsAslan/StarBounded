package com.sbnd.world.celestial.core.gen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderCelestial extends WorldProvider {

    public WorldProviderCelestial() {
        setCloudRenderer(new NoCloudRenderer());
    }

    @Override
    public String getDimensionName() {
        return "SbndDim";
    }

    private static class NoCloudRenderer extends IRenderHandler {

        @Override
        public void render(float partialTicks, WorldClient world, Minecraft mc) { }

    }

    // Override this
    public String getFogString() {

        return "0x000000";

    }

    @Override
    public Vec3 getFogColor(float timeOfDay, float brightness) {

        int color = Integer.parseInt(getFogString().substring(2), 16);

        // Extract the red, green, and blue components
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;

        return Vec3.createVectorHelper(r, g, b);

    }

}
