package api.interfaces.spacecrafts;

import com.sbnd.lib.ModVars;

public interface ISpacecraftModule
{

    void setOwner(ISpacecraft owner);
    ISpacecraft getOwner();

    default void onSpacecraftTick(int interval) { };

    String getName();
    default String getUnlocalizedName()
    {
        return String.format("tile.%s.module.%s", ModVars.MOD_ID, getName());
    }

    boolean hasAbility();

}
