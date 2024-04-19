package com.sbnd.interfaces.spacecrafts;

import com.sbnd.lib.ModVars;
import net.minecraft.client.resources.I18n;

import java.util.Collection;
import java.util.List;

public interface ISpacecraftModule
{

    void setOwner(ISpaceCraft spacecraft);
    ISpaceCraft getOwner();

    void onModuleChange(Collection<ISpacecraftModule> modules);
    void onSpacecraftTick(ISpaceCraft spacecraft);

    default int getTickInterval()
    {
        return 20;
    }

    String getName();
    default String getUnlocalizedName()
    {
        return String.format("module.%s.module.%s", ModVars.MOD_ID, getName());
    }
    default String getReadableName()
    {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    default boolean groupWith(ISpacecraftModule groupedWith)
    {
        return groupedWith.getClass() == getClass();
    }

    List<String> getSummary();

    default boolean isDirty()
    {
        return false;
    }

    default void isDirty(boolean dirty)
    {
        /*
        if(dirty)
        {
            ISpaceCraft owner = getOwner();
            if (owner != null && !owner.isInvalid())
            {
                owner.markDirty();
            }
        }
        */
    }

}
