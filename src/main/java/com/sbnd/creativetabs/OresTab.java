package com.sbnd.creativetabs;

import com.sbnd.content.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class OresTab extends CreativeTabs {

    public OresTab(int id, String name) {

        super(id, name);

    }

    @Override
    public Item getTabIconItem() {

        if(ModBlocks.oreZirconium != null) {

            return Item.getItemFromBlock(ModBlocks.oreZirconium);

        }

        return Items.diamond;

    }

}
