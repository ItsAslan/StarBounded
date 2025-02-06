package com.sbnd.server.block.spacecraft;

import com.sbnd.server.block.BlockSpacecraftGeneric;
import com.sbnd.server.tileentity.spacecraft.TileThruster;
import lombok.NonNull;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockThruster extends BlockSpacecraftGeneric {

    public BlockThruster(Material material) {
        super(material);
    }

    @Override
    public TileEntity createTileEntity(@NonNull World world, int metadata) {
        return new TileThruster("tile.thruster");
    }

}
