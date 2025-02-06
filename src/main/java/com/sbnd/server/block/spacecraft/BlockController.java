package com.sbnd.server.block.spacecraft;

import com.sbnd.server.block.BlockSpacecraftGeneric;
import com.sbnd.server.tileentity.spacecraft.TileController;
import lombok.NonNull;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockController extends BlockSpacecraftGeneric {

    public BlockController(Material material) {
        super(material);

    }

    @Override
    public TileEntity createTileEntity(@NonNull World world, int metadata) {
        return new TileController("tile.controller");
    }

}
