package api.planets;

import api.NoCloudRenderer;
import api.enums.EnumPlanet;
import api.interfaces.planets.IAtmosphere;
import com.sbnd.world.PlanetManager;
import com.sbnd.world.dimension.moon.WorldChunkManagerMoon;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public abstract class WorldProviderPlanet extends WorldProvider
{

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = PlanetManager.getWorldChunkManager(getPlanet());
        this.dimensionId = PlanetManager.getPlanetId(getPlanet());
        if(!hasClouds()) { setCloudRenderer(new NoCloudRenderer()); }
    }

    @Override
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
        return PlanetManager.getFogColor(getPlanet());
    }

    @Override
    public String getDimensionName() {
        return PlanetManager.getPlanetName(getPlanet());
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return PlanetManager.getChunkProvider(getPlanet(), this.worldObj);
    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return PlanetManager.getSkyRenderer(getPlanet());
    }

    public IAtmosphere getAtmosphere()
    {
        return PlanetManager.getAtmosphere(getPlanet());
    }

    protected abstract EnumPlanet getPlanet();
    protected abstract boolean hasClouds();


}
