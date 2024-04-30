package com.sbnd.world.dimension.moon;

import api.NoCloudRenderer;
import api.enums.EnumPlanet;
import com.sbnd.lib.Library;
import com.sbnd.render.sky.MoonSkyRender;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderMoon extends WorldProvider
{

    private final EnumPlanet planet = EnumPlanet.MOON;

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerMoon();
        this.dimensionId = Library.getPlanetId(planet);
        setCloudRenderer(new NoCloudRenderer());
    }

    @Override
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
        return Vec3.createVectorHelper(0, 0, 0);
    }

    @Override
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
        return Vec3.createVectorHelper(0, 0, 0);
    }

    @Override
    public String getDimensionName() {
        return Library.getPlanetName(planet);
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderMoon(this.worldObj, this.worldObj.getSeed(), false);
    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return new MoonSkyRender();
    }
}
