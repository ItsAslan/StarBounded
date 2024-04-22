package com.sbnd.interfaces.spacecrafts;

public interface IRegisteredSpacecraft
{

    void setName(String name);
    String getName();

    boolean isOrbiting();
    default boolean isMannable()
    {
        return false;
    }
    void setMannable(boolean set);
    boolean isDestroyed();

    boolean canLaunch();
    void launch();

}
