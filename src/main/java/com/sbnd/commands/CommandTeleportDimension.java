package com.sbnd.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.DimensionManager;

public class CommandTeleportDimension extends CommandBase
{

    @Override
    public String getCommandName() {
        return "teleportDimension";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/teleportDimension <dimensionId>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if(args.length > 0 && sender instanceof EntityPlayerMP)
        {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            int dimensionId = parseInt(sender, args[0]);
            if(DimensionManager.isDimensionRegistered(dimensionId))
            {
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dimensionId);
            }
            else
            {
                player.addChatMessage(new ChatComponentText("Dimension ID doesn't exist"));
            }

        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
