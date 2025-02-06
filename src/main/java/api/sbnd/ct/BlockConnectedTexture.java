package api.sbnd.ct;

import api.sbnd.ModVars;
import com.sbnd.server.block.BlockGeneric;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lombok.RequiredArgsConstructor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockConnectedTexture extends BlockGeneric {

    @SideOnly(Side.CLIENT)
    private IIcon texture;
    @SideOnly(Side.CLIENT)
    private IIcon top;

    public BlockConnectedTexture(Material material) {
        super(material);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = iconRegister.registerIcon(ModVars.MOD_ID + ":test");
        top = iconRegister.registerIcon(ModVars.MOD_ID + ":testTop");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {

        if(side == 0 || side == 1) {

            return top;

        }

        if(check(world.getBlock(x, y + 1, z)) && check(world.getBlock(x, y - 1, z))) {

            return new SubIcon(texture, 0f, 0.5f, 0f, 0.5f);

        }

        if(check(world.getBlock(x, y + 1, z))) {

            return new SubIcon(texture, 0.5f, 1f, 0f, 0.5f);

        }

        if(check(world.getBlock(x, y - 1, z))) {

            return new SubIcon(texture, 0f, 0.5f, 0.5f, 1f);

        }

        return new SubIcon(texture, 0.5f, 1f, 0.5f, 1f);

    }

    private boolean check(Block block) {

        return block.getClass() == getClass();

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {

        if(side == 0 || side == 1) {

            return top;

        }

        return new SubIcon(texture, 0.0f, 0.25f, 0.0f, 0.5f);

    }

    @RequiredArgsConstructor
    @SideOnly(Side.CLIENT)
    private static class SubIcon implements IIcon {

        private final IIcon base;
        private final float minU, maxU, minV, maxV;

        @Override
        public int getIconWidth() {
            return base.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return base.getIconHeight();
        }

        @Override public float getMinU() { return base.getInterpolatedU(minU * 16); }
        @Override public float getMaxU() { return base.getInterpolatedU(maxU * 16); }
        @Override public float getMinV() { return base.getInterpolatedV(minV * 16); }
        @Override public float getMaxV() { return base.getInterpolatedV(maxV * 16); }

        @Override
        public float getInterpolatedU(double value) {
            return (float) (getMinU() + (getMaxU() - getMinU()) * value / 16D);
        }

        @Override
        public float getInterpolatedV(double value) {
            return (float) (getMinV() + (getMaxV() - getMinV()) * value / 16D);
        }

        @Override
        public String getIconName() {
            return String.format("%s@U:%f_V:%f", base.getIconName(), getMaxU(), getMaxV());
        }

    }

}
