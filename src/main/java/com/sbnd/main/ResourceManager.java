package com.sbnd.main;

import com.sbnd.lib.ModVars;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ResourceManager
{

    //MODELS
    public static IModelCustom TEST_OBJ_MODEL = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/blocks/test.obj"));

    //TEXTURES
    public static ResourceLocation TEST_OBJ_TEXTURE = new ResourceLocation(ModVars.MOD_ID, "textures/models/testTexture.png");

    //Planets
    public static ResourceLocation EARTH = new ResourceLocation(ModVars.MOD_ID, "textures/celestial/planets/earthTexture.png");
    public static ResourceLocation MOON = new ResourceLocation(ModVars.MOD_ID, "textures/celestial/planets/moonTexture.png");
    public static ResourceLocation MARS = new ResourceLocation(ModVars.MOD_ID, "textures/celestial/planets/marsTexture.png");

    //Stars
    public static ResourceLocation SUN = new ResourceLocation(ModVars.MOD_ID, "textures/celestial/stars/sunTexture.png");

}
