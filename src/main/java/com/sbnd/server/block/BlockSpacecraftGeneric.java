package com.sbnd.server.block;

import com.sbnd.server.tileentity.spacecraft.TileModuleGeneric;
import lombok.NonNull;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockSpacecraftGeneric extends BlockGeneric {
    public static final ThreadLocal<Boolean> CONVERTING = ThreadLocal.withInitial(() -> false);

    public BlockSpacecraftGeneric(Material material) {
        super(material);
    }

    public BlockSpacecraftGeneric(MapColor color, Material material) {
        super(color, material);
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(@NonNull World world, int metadata) {
        return new TileModuleGeneric("tile.module");
    }

}
