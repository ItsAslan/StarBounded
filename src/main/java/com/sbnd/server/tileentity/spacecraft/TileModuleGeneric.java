package com.sbnd.server.tileentity.spacecraft;

import api.sbnd.interfaces.ISpacecraft;
import api.sbnd.interfaces.ISpacecraftModule;
import com.sbnd.server.tileentity.TileEntityGeneric;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

@RequiredArgsConstructor
@ParametersAreNonnullByDefault
public class TileModuleGeneric extends TileEntityGeneric implements ISpacecraftModule {

    @Getter
    private final UUID id = UUID.randomUUID();

    @Getter
    @Setter
    private ISpacecraft owner;

    @Getter
    private final String name;

    @Override
    public String toString() {
        return getName();
    }

}
