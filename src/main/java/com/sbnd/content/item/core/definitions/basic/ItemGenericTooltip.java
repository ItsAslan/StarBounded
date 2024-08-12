package com.sbnd.content.item.core.definitions.basic;

import com.sbnd.world.tmp.core.bodies.CelestialBody;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemGenericTooltip extends ItemGeneric {

    String location;

    public ItemGenericTooltip(List<Item> registry, String location) {
        super( registry );

        this.location = location;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);

        CelestialBody body = CelestialBody.getBody(location);

        if(body != null) {

            list.add("Found On " + body.getFormatColor() + body.getName().toUpperCase());

        }

    }

}
