package com.sbnd.main;

import com.sbnd.lib.ModVars;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
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
}
