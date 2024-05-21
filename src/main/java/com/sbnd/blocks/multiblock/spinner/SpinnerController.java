package com.sbnd.blocks.multiblock.spinner;

import com.sbnd.blocks.multiblock.base.ControllerBase;
import com.sbnd.blocks.multiblock.base.ModuleBase;
import net.minecraft.block.material.Material;

import java.util.ArrayList;

public class SpinnerController extends ControllerBase {

    ArrayList<ModuleBase> modules = new ArrayList<>();

    public SpinnerController(Material material) {
        super(material);
    }

    @Override
    public void newBlockAdded(ModuleBase block) {
        modules.add(block);
    }

    @Override
    public void tick() {
        System.out.printf("\n%d module[s] connected", modules.size());
    }

}
