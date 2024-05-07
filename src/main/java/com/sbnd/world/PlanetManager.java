package com.sbnd.world;

import api.enums.EnumPlanet;
import api.interfaces.planets.IAtmosphere;
import api.planets.PlanetSkyRender;
import com.sbnd.render.sky.MarsSkyRender;
import com.sbnd.render.sky.MercurySkyRender;
import com.sbnd.render.sky.MoonSkyRender;
import com.sbnd.render.sky.VenusSkyRender;
import com.sbnd.world.dimension.mars.ChunkProviderMars;
import com.sbnd.world.dimension.mars.MarsAtmosphere;
import com.sbnd.world.dimension.mars.WorldChunkManagerMars;
import com.sbnd.world.dimension.mercury.ChunkProviderMercury;
import com.sbnd.world.dimension.mercury.ChunkProviderVenus;
import com.sbnd.world.dimension.mercury.MercuryAtmosphere;
import com.sbnd.world.dimension.mercury.WorldChunkManagerMercury;
import com.sbnd.world.dimension.moon.ChunkProviderMoon;
import com.sbnd.world.dimension.moon.MoonAtmosphere;
import com.sbnd.world.dimension.moon.WorldChunkManagerMoon;
import com.sbnd.world.dimension.venus.VenusAtmosphere;
import com.sbnd.world.dimension.venus.WorldChunkManagerVenus;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class PlanetManager
{

    public static IAtmosphere getAtmosphere(EnumPlanet planet)
    {
        switch(planet)
        {
            case MOON:
                return new MoonAtmosphere();
            case MARS:
                return new MarsAtmosphere();
            case MERCURY:
                return new MercuryAtmosphere();
            case VENUS:
                return new VenusAtmosphere();
            default:
                return null;
        }
    }

    public static float[] getSkyColor(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return getColorArray(new float[]{0, 0, 0});
            case MARS:
                return getColorArray(new float[]{171, 119, 67});
            case MERCURY:
                return getColorArray(new float[] {0, 0, 0});
            case VENUS:
                return getColorArray(new float[] {252, 173, 3});
            default:
                return getColorArray(new float[]{255, 255, 173});
        }
    }

    public static Vec3 getFogColor(EnumPlanet planet)
    {
        switch (planet)
        {
            case MOON:
                return getColor(new float[]{20, 20, 20});
            case MARS:
                return getColor(new float[]{133, 73, 33});
            case MERCURY:
                return getColor(new float[] {20, 20, 20});
            case VENUS:
                return getColor(new float[] {163, 115, 26});
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
            case MERCURY:
                return "Mercury";
            case VENUS:
                return "Venus";
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
            case MERCURY:
                return new ChunkProviderMercury(world, world.getSeed(), false);
            case VENUS:
                return new ChunkProviderVenus(world, world.getSeed(), false);
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
            case MERCURY:
                return new WorldChunkManagerMercury();
            case VENUS:
                return new WorldChunkManagerVenus();
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
            case MERCURY:
                return new MercurySkyRender();
            case VENUS:
                return new VenusSkyRender();
            default:
                return null;
        }
    }

    public static float getPrimaryPlanetRotation(EnumPlanet planet)
    {
        switch(planet)
        {
            case MOON:
                return 75;
            default:
                return 0;
        }
    }

    public static float getPrimaryPlanetSize(EnumPlanet planet)
    {
        switch(planet)
        {
            case MOON:
                return 1;
            default:
                return 0;
        }
    }

    public static float getStarRotation(EnumPlanet planet)
    {
        switch(planet)
        {
            case MOON:
                return 200;
            case MARS:
                return 200;
            case MERCURY:
                return 255;
            case VENUS:
                return 235;
            default:
                return 0;
        }
    }

    public static float getStarSize(EnumPlanet planet)
    {
        switch(planet)
        {
            case MOON:
                return 20.0f;
            case MARS:
                return 20.0f / 3.5f;
            case MERCURY:
                return 160.0f;
            case VENUS:
                return 34.0f;
            default:
                return 0;
        }
    }

    public static EnumPlanet getPlanetFromId(int id)
    {
        switch(id)
        {
            case 2:
                return EnumPlanet.MOON;
            case 3:
                return EnumPlanet.MARS;
            case 4:
                return EnumPlanet.MERCURY;
            case 5:
                return EnumPlanet.VENUS;
            default:
                return null;
        }
    }

    public static int getPlanetId(EnumPlanet planet)
    {
        return planet.getDimensionId();
    }

    public static String getPlanetName(EnumPlanet planet)
    {
        return planet.getName();
    }


    private static Vec3 getColor(float[] color)
    {
        return Vec3.createVectorHelper(color[0] / 255.0f, color[1] / 255.0f, color[2] / 255.0f);
    }

    private static float[] getColorArray(float[] color)
    {
        return new float[] {color[0] / 255.0f, color[1] / 255.0f, color[2] / 255.0f};
    }

}
