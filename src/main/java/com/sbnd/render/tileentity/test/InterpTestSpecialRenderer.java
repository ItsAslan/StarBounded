package com.sbnd.render.tileentity.test;

import com.sbnd.lib.ModVars;
import com.sbnd.tileentity.test.TestInterpTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class InterpTestSpecialRenderer extends TileEntitySpecialRenderer
{

    IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/blocks/test.obj"));
    ResourceLocation texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/testTexture.png");

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
        if (te instanceof TestInterpTileEntity) {
            float height = ((TestInterpTileEntity) te).getCurrentHeight();

            System.out.println(height);

            GL11.glPushMatrix();
            GL11.glTranslatef((float) (x + 0.5), (float) (y + height + 0.5), (float) (z + 0.5));
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
            model.renderAll();
            GL11.glPopMatrix();
        }
    }
}
