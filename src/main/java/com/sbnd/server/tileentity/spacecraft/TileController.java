package com.sbnd.server.tileentity.spacecraft;

import api.sbnd.interfaces.ISpacecraftController;
import lombok.NonNull;

public class TileController extends TileModuleGeneric implements ISpacecraftController {

    public TileController(@NonNull String name) {
        super(name);
    }

}
