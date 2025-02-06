package api.sbnd.ct;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lombok.RequiredArgsConstructor;
import net.minecraft.util.IIcon;

@RequiredArgsConstructor
@SideOnly(Side.CLIENT)
public class IconCT implements IIcon {

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
        return String.format("%s@U%fV%f", base.getIconName(), getMaxU(), getMaxV());
    }

}
