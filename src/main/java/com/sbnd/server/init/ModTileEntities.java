package com.sbnd.server.init;

import com.sbnd.server.tileentity.spacecraft.TileController;
import com.sbnd.server.tileentity.spacecraft.TileFuselage;
import com.sbnd.server.tileentity.spacecraft.TileThruster;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class ModTileEntities {
    
    public static void register() {

        registerTileEntity(TileController.class, "tile.controller");
        registerTileEntity(TileFuselage.class, "tile.fuselage");
        registerTileEntity(TileThruster.class, "tile.thruster");

    }

    private static void registerTileEntity(Class<? extends TileEntity> clazz, String registryName) {

        GameRegistry.registerTileEntity(clazz, registryName);

    }
    
}
