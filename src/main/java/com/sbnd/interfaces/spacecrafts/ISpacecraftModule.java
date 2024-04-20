package com.sbnd.interfaces.spacecrafts;

import com.sbnd.enums.EnumModuleAbility;
import com.sbnd.lib.ModVars;

public interface ISpacecraftModule
{

    void setOwner(ISpacecraft owner);
    ISpacecraft getOwner();

    void onSpacecraftTick(int interval);

    String getName();
    default String getUnlocalizedName()
    {
        return String.format("tile.%s.module.%s", ModVars.MOD_ID, getName());
    }

    void setModuleAbility(EnumModuleAbility ability);
    EnumModuleAbility getModuleAbility();

}
