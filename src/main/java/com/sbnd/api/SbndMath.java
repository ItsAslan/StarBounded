package com.sbnd.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

public class SbndMath
{
    public static ForgeDirection getPlayerCardinalDirection(EntityPlayer player) {
        float yaw = (player.rotationYaw % 360 + 360) % 360; // Normalize to 0-360 degrees
        if (yaw >= 45 && yaw < 135) {
            return ForgeDirection.WEST;
        } else if (yaw >= 135 && yaw < 225) {
            return ForgeDirection.NORTH;
        } else if (yaw >= 225 && yaw < 315) {
            return ForgeDirection.EAST;
        } else {
            return ForgeDirection.SOUTH;
        }
    }
}
