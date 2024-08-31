package com.sbnd.main;

import com.sbnd.world.celestial.core.bodies.CelestialBody;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
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

    @SubscribeEvent
    public void onEntityTick(LivingEvent.LivingUpdateEvent event) {

        int id = event.entity.worldObj.provider.dimensionId;

        if(id != -1 && id != 1) {

            CelestialBody body = CelestialBody.getBody(id);
            double gravity = body.getGravity() * SbndUtil.GRAVITY_MULTIPLIER;

            boolean isFlying = event.entity instanceof EntityPlayer && ((EntityPlayer) event.entity).capabilities.isFlying;

            if (!isFlying && !event.entityLiving.isInWater() && event.entityLiving.ticksExisted > 20 && (gravity < 1.5F || gravity > 1.7F)) {

                if (gravity < 0.2F) gravity = 0.2F; // thanks :)

                if (gravity < 1.5F || event.entityLiving.motionY < 0) {

                    event.entityLiving.motionY /= 0.98F;
                    event.entityLiving.motionY += (SbndUtil.DEFAULT_MC_GRAVITY / 20F);
                    event.entityLiving.motionY -= (gravity / 20F);
                    event.entityLiving.motionY *= 0.98F;

                }

            }

        }

    }

}
