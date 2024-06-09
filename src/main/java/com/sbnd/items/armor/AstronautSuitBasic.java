package com.sbnd.items.armor;

import com.sbnd.items.generic.AstonautSuitBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class AstronautSuitBasic extends AstonautSuitBase
{

    public AstronautSuitBasic(ArmorMaterial material, int renderIndex, int armorType, String root) {
        super(material, renderIndex, armorType, root);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);

        list.add(EnumChatFormatting.BLUE + "Oxygen Level: " + getCurrentOxygen());

        list.add("");

        if(isFireResistant()) {
            list.add(EnumChatFormatting.RED + "[FIRE RESISTANT]");
        }
        if(radiationAbsorption() > 0) {
            list.add(EnumChatFormatting.GREEN + "[RADIATION ABSORPTION: " + radiationAbsorption() + "]");
        }

    }
}
