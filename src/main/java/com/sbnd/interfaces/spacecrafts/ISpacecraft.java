package com.sbnd.interfaces.spacecrafts;

import java.util.Collection;

public interface ISpacecraft
{

    String getName();

    ISpacecraftController getController();

    Collection<ISpacecraftModule> getModules();

    IRegisteredSpacecraft registerSpaceCraft();

}
