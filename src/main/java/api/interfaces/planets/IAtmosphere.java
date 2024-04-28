package api.interfaces.planets;

import api.enums.EnumGasType;
import net.minecraft.entity.EntityLivingBase;

public interface IAtmosphere
{

    boolean isImmune(EntityLivingBase player);

    boolean isBreathable();
    double radiationPassThrough(); // 1 - 100

    void onTick(EntityLivingBase player);

    EnumGasType primaryAtmosphericGasType();

}
