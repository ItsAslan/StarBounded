package com.sbnd.items.generic;

import com.sbnd.enums.EnumPlanet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemOreGeneric extends Item
{

    EnumPlanet planet = null;

    public ItemOreGeneric()
    {

    }

    public ItemOreGeneric(EnumPlanet planet)
    {
        this.planet = planet;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);

        if(planet != null)
        {
            list.add(planet.getColor() + "Found on " + planet.getName());
        }

    }
}
