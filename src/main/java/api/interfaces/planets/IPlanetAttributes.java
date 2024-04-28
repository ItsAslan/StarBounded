package api.interfaces.planets;

import api.BlockCoordinate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;


public interface IPlanetAttributes
{

    double getGravityMultiplier(BlockCoordinate pos);

    // For moons
    int getOrbitingDimension(BlockCoordinate pos);

    float getAtmosphereDensity(BlockCoordinate pos);

    float getAverageTemperature(BlockCoordinate pos); // IN CELSIUS

    int getWetness();
    double getRadiationLevel();

    boolean isPlanet();
    boolean isGasGiant();

    boolean hasRings();
    Vec3 getRingColor();

    boolean hasSky();
    Vec3 planetSkyColor();

    IAtmosphere getAtmosphere();

    int getParentPlanet();

    ResourceLocation planetIcon();

}
