package com.sbnd.content.transport.spacecraft.core.craft;

public interface ISpacecraftModule {

    ISpacecraft getOwner();
    void setOwner(ISpacecraft craft);

    ISpacecraftController getController();

}
