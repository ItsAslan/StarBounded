package api.interfaces.spacecrafts;

import java.util.Collection;

public interface ISpacecraft extends IRegisteredSpacecraft
{

    String getName();

    ISpacecraftController getController();

    Collection<ISpacecraftModule> getModules();

    IRegisteredSpacecraft registerSpaceCraft();

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
