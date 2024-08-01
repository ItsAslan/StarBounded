package com.sbnd.main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;

public class ModEventListener {

    @SubscribeEvent
    public void onPlayerChangeDimension(LivingEvent.LivingUpdateEvent event) {

        if (event.entity instanceof EntityPlayerMP) {

            EntityPlayerMP player = (EntityPlayerMP) event.entity;

            if (player.dimension == 2) { // Old Planet System has Moon Dimension as 2

                player.addStat(Starbounded.moonLanding, 1);

            }

        }

    }

}
