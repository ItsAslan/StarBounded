package com.sbnd.server.tileentity.spacecraft;

import api.sbnd.interfaces.ISpacecraftModule;
import lombok.NonNull;

public class TileFuselage extends TileModuleGeneric implements ISpacecraftModule {

    public TileFuselage(@NonNull String name) {
        super(name);
    }

}
