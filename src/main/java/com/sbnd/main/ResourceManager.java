package com.sbnd.main;

import com.sbnd.lib.ModVars;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ResourceManager
{
    public static IModelCustom TEST_OBJ_MODEL = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/blocks/test.obj"));
    public static ResourceLocation TEST_OBJ_TEXTURE = new ResourceLocation(ModVars.MOD_ID, "textures/models/testTexture.png");
}
