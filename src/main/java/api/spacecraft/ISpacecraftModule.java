package api.spacecraft;

import api.interfaces.annotations.ToDo;
import api.util.interfaces.IUnique;
import com.sbnd.lib.ModVars;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public interface ISpacecraftModule extends IUnique {

    void setOwner(ISpacecraft spacecraft);

    ISpacecraft getOwner();

    @ToDo("Ticking stuff")
    default void tick(ISpacecraft spacecraft) {

        // Ticking Stuff

    }

    String getName();

    default String getUnlocalizedName() {
        return String.format("tile.%s.module.%s", ModVars.MOD_ID, getName());
    }

    @SideOnly(Side.CLIENT)
    default String getLocalizedName() {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    ResourceLocation getRegistryName();

    ISpacecraftModule setRegistryName(ResourceLocation registryName);

    default boolean groupWith(ISpacecraftModule other) {
        return other.getClass() == getClass();
    }

}
