package com.sbnd.render.tileentity.machine;

import com.sbnd.main.ResourceManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class MixerTileRenderer extends TileEntitySpecialRenderer {

    IModelCustom model = ResourceManager.MIXER_MODULE_MODEL;
    ResourceLocation texture = ResourceManager.MIXER_MODULE_TEXTURE;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();

    }

}