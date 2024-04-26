package com.sbnd.items.generic;

import com.sbnd.lib.ModVars;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorGeneric extends ItemArmor
{

    private final String layer1;
    private final String layer2;

    public ArmorGeneric(ArmorMaterial material, int renderIndex, int armorType, String root) {
        super(material, renderIndex, armorType);

        layer1 = String.format("%s:models/armor/%s_layer_1.png", ModVars.MOD_ID, root);
        layer2 = String.format("%s:models/armor/%s_layer_2.png", ModVars.MOD_ID, root);

    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return this.armorType == 2 ? layer2 : layer1;
    }
}
