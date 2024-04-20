package com.sbnd.interfaces.spacecrafts;

public interface IRegisteredSpacecraft
{

    void setName(String name);
    String getName();

    boolean isOrbiting();
    boolean isManned();

    boolean canLaunch();
    void launch();

}
