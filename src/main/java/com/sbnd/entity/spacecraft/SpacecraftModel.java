package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraftBodyData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;

public class SpacecraftModel {

    RenderBlocks BLOCK_RENDERER = new RenderBlocks();
    Tessellator TESSELLATOR = Tessellator.instance;

    @SideOnly(Side.CLIENT)
    static SpacecraftModel build(ISpacecraftBodyData data) {

        return null;

    }

    void drawBlocks(ISpacecraftBodyData data, int layer) {



    }


}
