package com.sbnd.blocks.test;

import com.sbnd.tileentity.test.TestInterpTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class interpTest extends BlockContainer
{

    public interpTest(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote)
        {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof TestInterpTileEntity)
            {
                ((TestInterpTileEntity) tileEntity).setActive(true);
            }
        }

        return true;

    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1; // This tells Minecraft that the block does not have a default render type
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false; // This makes sure that the block doesn't block rendering of adjacent blocks.
    }


    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TestInterpTileEntity();
    }
}
