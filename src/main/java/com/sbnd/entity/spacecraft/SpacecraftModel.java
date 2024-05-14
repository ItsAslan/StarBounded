package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraftBodyData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public interface SpacecraftModel {

    RenderBlocks BLOCK_RENDERER = new RenderBlocks();
    Tessellator TESSELLATOR = Tessellator.instance;

    @SideOnly(Side.CLIENT)
    static SpacecraftModel build(ISpacecraftBodyData data) {

        return new DisplayListSpacecraftModel(data);

    }

    default void drawBlocks(ISpacecraftBodyData data, int layer) {

        World world = Minecraft.getMinecraft().theWorld;

        TESSELLATOR.startDrawingQuads();
        for (int x = (int) data.getMinPos().x; x <= getBody().getMaxPos().x; x++) {

            for(int y = (int) data.getMinPos().y; y <= data.getMaxPos().y; y++) {

                for(int z = (int) data.getMinPos().z; z <= data.getMaxPos().z; z++) {
                    Block block = world.getBlock(x, y, z);
                    int meta = world.getBlockMetadata(x, y, z);

                    if (block != Blocks.air && block.canRenderInPass(layer)) {
                        TESSELLATOR.setTranslation(x, y, z);
                        BLOCK_RENDERER.renderBlockByRenderType(block, x, y, z);
                    }

                }

            }

            TESSELLATOR.draw();

        }

    }

    void render(int layer);
    void delete();
    boolean isAvailable();
    ISpacecraftBodyData getBody();


}
