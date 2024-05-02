package com.sbnd.world;

import api.enums.EnumPlanet;
import api.planets.PlanetSkyRender;
import com.sbnd.render.sky.MarsSkyRender;
import com.sbnd.render.sky.MoonSkyRender;
import com.sbnd.world.dimension.mars.ChunkProviderMars;
import com.sbnd.world.dimension.mars.WorldChunkManagerMars;
import com.sbnd.world.dimension.moon.ChunkProviderMoon;
import com.sbnd.world.dimension.moon.WorldChunkManagerMoon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class PlanetManager
{

    public static float[] getSkyColor(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return getColorArray(new float[]{0, 0, 0});
            case MARS:
                return getColorArray(new float[]{171, 119, 67});
            default:
                return getColorArray(new float[]{255, 255, 173});
        }
    }

    public static Vec3 getFogColor(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return getColor(new float[]{0, 0, 0});
            case MARS:
                return getColor(new float[]{133, 73, 33});
            default:
                return getColor(new float[]{255, 255, 255});
        }
    }

    public static String getDimensionName(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return "Moon";
            case MARS:
                return "Mars";
            default:
                return "Null";
        }
    }

    public static IChunkProvider getChunkProvider(EnumPlanet planet, World world)
    {
        switch (planet)
        {
            case MOON:
                return new ChunkProviderMoon(world, world.getSeed(), false);
            case MARS:
                return new ChunkProviderMars(world, world.getSeed(), false);
            default:
                return null;
        }
    }

    public static WorldChunkManagerHell getWorldChunkManager(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return new WorldChunkManagerMoon();
            case MARS:
                return new WorldChunkManagerMars();
            default:
                return null;
        }
    }

    public static PlanetSkyRender getSkyRenderer(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return new MoonSkyRender();
            case MARS:
                return new MarsSkyRender();
            default:
                return null;
        }
    }

    private static Vec3 getColor(float[] color)
    {
        return Vec3.createVectorHelper(color[0] / 255.0f, color[1] / 255.0f, color[2] / 255.0f);
    }

    private static float[] getColorArray(float[] color)
    {
        return new float[] {color[0] / 255.0f, color[1] / 255.0f, color[2] / 255.0f};
    }

    public static int getPlanetId(EnumPlanet planet)
    {
        return planet.getDimensionId();
    }

    public static String getPlanetName(EnumPlanet planet)
    {
        return planet.getName();
    }

}
