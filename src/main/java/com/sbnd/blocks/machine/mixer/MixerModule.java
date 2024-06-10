package com.sbnd.blocks.machine.mixer;

import com.sbnd.blocks.machine.base.BaseMultiblockModule;
import com.sbnd.tileentity.machine.mixer.MixerModuleTE;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MixerModule extends BaseMultiblockModule {

    public MixerModule(Material p_i45386_1_) {
        super(p_i45386_1_);
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
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new MixerModuleTE();
    }

}
