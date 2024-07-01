package com.sbnd.content.crafting;

import com.sbnd.content.crafting.basic.furnace.BasicSmelting;
import com.sbnd.content.crafting.basic.table.BasicCrafting;

public class CraftingRegistry {

    public static void REGISTER() {

        BasicSmelting.REGISTER();
        BasicCrafting.REGISTER();

    }

}
