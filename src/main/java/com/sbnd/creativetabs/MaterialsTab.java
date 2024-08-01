package com.sbnd.creativetabs;

import com.sbnd.content.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MaterialsTab extends CreativeTabs {

    public MaterialsTab(int id, String name) {

        super(id, name);

    }

    @Override
    public Item getTabIconItem() {

        if(ModItems.ingotTungsten != null) {

            return ModItems.ingotTungsten;

        }

        return Items.diamond;

    }

}
