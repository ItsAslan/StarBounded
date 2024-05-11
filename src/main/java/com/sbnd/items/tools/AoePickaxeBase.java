package com.sbnd.items.tools;

import api.util.SbndMath;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.input.Keyboard;

public class AoePickaxeBase extends ItemPickaxe
{
    private int COLUMNSIZE;
    private int ROWSIZE;

    public AoePickaxeBase(ToolMaterial mat, int ROWSIZE, int COLUMNSIZE) {
        super(mat);
        this.ROWSIZE = ROWSIZE / 2;
        this.COLUMNSIZE = COLUMNSIZE / 2;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {
        if(!world.isRemote && player instanceof EntityPlayer)
        {
            if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            {
                return super.onBlockDestroyed(stack, world, block, x, y, z, player);
            }
            else
            {
                EntityPlayer playerEntity = (EntityPlayer) player;
                ForgeDirection direction = SbndMath.getPlayerCardinalDirection(playerEntity);

                for(int i = -COLUMNSIZE; i <= COLUMNSIZE; ++i)
                {
                    for(int j = -ROWSIZE; j <= ROWSIZE; ++j)
                    {
                        int newX = x;
                        int newY = y + i;
                        int newZ = z;

                        if(direction.equals(ForgeDirection.NORTH) || direction.equals(ForgeDirection.SOUTH)) {
                            newX += j;
                        } else {
                            newZ += j;
                        }

                        if(!(i == 0 && j == 0)) {
                            Block blockToBreak = world.getBlock(newX, newY, newZ);
                            if(blockToBreak != Blocks.air) {
                                blockToBreak.dropBlockAsItem(world, newX, newY, newZ, world.getBlockMetadata(newX, newY, newZ), 0);
                                world.setBlockToAir(newX, newY, newZ);
                            }
                        }
                    }
                }
            }
        }

        return super.onBlockDestroyed(stack, world, block, x, y, z, player);
    }

}
