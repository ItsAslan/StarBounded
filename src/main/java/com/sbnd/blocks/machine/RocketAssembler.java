package com.sbnd.blocks.machine;

import com.sbnd.tileentity.machine.RocketAssemblerTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RocketAssembler extends BlockContainer
{

    public RocketAssembler(Material material) {
        super(material);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int orientation = MathHelper.floor_double((entity.rotationYaw * 4.0F) / 360.0F + 0.5D) & 3;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof RocketAssemblerTileEntity) {
            ((RocketAssemblerTileEntity) tile).setOrientation(orientation);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new RocketAssemblerTileEntity();
    }
}
