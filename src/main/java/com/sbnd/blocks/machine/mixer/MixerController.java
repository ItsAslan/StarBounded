package com.sbnd.blocks.machine.mixer;

import com.sbnd.blocks.machine.base.BaseMultiblockController;
import com.sbnd.lib.ModVars;
import com.sbnd.tileentity.machine.mixer.MixerControllerTE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MixerController extends BaseMultiblockController {

    public MixerController(Material p_i45386_1_) {
        super(p_i45386_1_);
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[6];

        icons[0] = reg.registerIcon(ModVars.MOD_ID + ":mixerTop"); // Bottom
        icons[1] = reg.registerIcon(ModVars.MOD_ID + ":mixerBottom"); // Top
        icons[2] = reg.registerIcon(ModVars.MOD_ID + ":mixerSide"); // North
        icons[3] = reg.registerIcon(ModVars.MOD_ID + ":mixerFront"); // South
        icons[4] = reg.registerIcon(ModVars.MOD_ID + ":mixerSide"); // West
        icons[5] = reg.registerIcon(ModVars.MOD_ID + ":mixerSide"); // East

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[side];
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new MixerControllerTE();
    }

}
