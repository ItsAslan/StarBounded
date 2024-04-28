package api.interfaces.spacecrafts;

import api.enums.EnumModuleAbility;

import java.util.Collection;
import java.util.HashSet;

public interface ISpacecraft extends IRegisteredSpacecraft
{

    String getName();

    ISpacecraftController getController();

    Collection<ISpacecraftModule> getModules();

    IRegisteredSpacecraft registerSpaceCraft();

    default Collection<EnumModuleAbility> getModuleAbilities()
    {
        Collection<EnumModuleAbility> abilities = new HashSet<>();

        for(ISpacecraftModule module : getModules())
        {
            if(module.hasAbility())
            {
                abilities.add(module.getModuleAbility());
            }
        }

        return abilities;
    }

    default boolean isManned()
    {
        return false;
    }
    void setManned(boolean set);

    void onRemoved();

    void track();
    void untrack();
    void markDirty();

}
