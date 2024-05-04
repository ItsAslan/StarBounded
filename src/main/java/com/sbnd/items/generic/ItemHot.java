package com.sbnd.items.generic;

import api.enums.EnumPlanet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHot extends ItemOreGeneric
{

    public ItemHot(EnumPlanet planet)
    {
        super(planet);
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity player, int i, boolean b)
    {
        if(!world.isRemote)
        {
            if(player instanceof EntityPlayer)
            {
                if(((EntityPlayer) player).getHeldItem() != null && !((EntityPlayer) player).capabilities.isCreativeMode)
                {
                    if(((EntityPlayer) player).getHeldItem().getItem() == this)
                    {
                        player.setFire(3);
                    }
                }
            }
        }
    }
}
