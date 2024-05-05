package com.sbnd.blocks.generic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockGlassGeneric extends BlockBreakable
{

    public BlockGlassGeneric(String name, Material material, boolean isSolid) {
        super(name, material, isSolid);
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }

}
