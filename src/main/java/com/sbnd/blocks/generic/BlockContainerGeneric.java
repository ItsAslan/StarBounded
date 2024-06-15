package com.sbnd.blocks.generic;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockContainerGeneric extends BlockContainer {

    public BlockContainerGeneric(Material material) {
        super(material);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
        int i = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if(i == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if(i == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if(i == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if(i == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
    
}
