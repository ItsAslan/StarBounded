package com.sbnd.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class CommandTeleportDimension extends CommandBase {

    @Override
    public String getCommandName() {
        return "teleportDimension";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/teleportDimension <dimensionId>";
    }

    /**
     *  A small hack to teleport between dimensions other than the nether or end.
     *  There must be a better way to do this though
     */
    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if(args.length > 0 && sender instanceof EntityPlayerMP) {

            EntityPlayerMP player = (EntityPlayerMP) sender;
            int dimensionId = parseInt(sender, args[0]);

            if(DimensionManager.isDimensionRegistered(dimensionId)) {

                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 1);

                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dimensionId);

                player.setPositionAndUpdate(player.posX, player.posY, player.posZ);

                WorldServer worldServer = player.mcServer.worldServerForDimension(dimensionId);
                worldServer.theChunkProviderServer.loadChunk((int) player.posX >> 4, (int) player.posZ >> 4);

            } else {

                player.addChatMessage(new ChatComponentText("Dimension ID doesn't exist"));

            }

        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

}