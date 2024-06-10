package com.sbnd.render.item.machine;

import com.sbnd.main.ResourceManager;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class MixerItemRenderer implements IItemRenderer
{

    private final IModelCustom model = ResourceManager.MIXER_MODULE_MODEL;
    private final ResourceLocation texture = ResourceManager.MIXER_MODULE_TEXTURE;

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();

        GL11.glTranslated(0.0f, -0.5f, 0.0f);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();

        GL11.glPopMatrix();
    }
}