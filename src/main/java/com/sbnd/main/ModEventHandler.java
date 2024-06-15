package com.sbnd.main;

import api.enums.EnumPlanet;
import api.interfaces.generic.ISpaceSuit;
import com.sbnd.lib.ModVars;
import com.sbnd.world.PlanetManager;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;

public class ModEventHandler
{

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        if(!event.player.worldObj.isRemote)
        {
            event.player.addChatMessage(new ChatComponentText("Loaded " + ModVars.MOD_NAME + " with version " + ModVars.MOD_VERSION + "!")
                    .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(!event.player.worldObj.isRemote && !event.player.capabilities.isCreativeMode)
        {
            if(PlanetManager.getPlanetFromId(event.player.worldObj.provider.dimensionId) != null)
            {

                EnumPlanet planet = PlanetManager.getPlanetFromId(event.player.worldObj.provider.dimensionId);

                if(!isWearingAstronautSuit(event.player))
                {
                    if(!PlanetManager.getAtmosphere(planet).canBreathe())
                    {
                        event.player.attackEntityFrom(DamageSource.drown, 2.0f);
                    }
                    if(PlanetManager.getAtmosphere(planet).isHot())
                    {
                        event.player.setFire(3);
                    }
                }
                else
                {
                    if(PlanetManager.getAtmosphere(planet).isHot() && !((ISpaceSuit) event.player.inventory.armorInventory[0].getItem()).isFireResistant())
                    {
                        event.player.setFire(3);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void worldTick(TickEvent.WorldTickEvent event) {

        Starbounded.NETWORKHANDLER.tickNetworks();

    }

    private boolean isWearingAstronautSuit(EntityPlayer player)
    {
        ItemStack helmet = player.inventory.armorInventory[0];
        ItemStack chestplate = player.inventory.armorInventory[1];
        ItemStack leggings = player.inventory.armorInventory[2];
        ItemStack boots = player.inventory.armorInventory[3];

        return (helmet != null && helmet.getItem() instanceof ISpaceSuit) &&
                (chestplate != null && chestplate.getItem() instanceof ISpaceSuit) &&
                (leggings != null && leggings.getItem() instanceof ISpaceSuit) &&
                (boots != null && boots.getItem() instanceof ISpaceSuit);
    }

}
