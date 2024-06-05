package com.sbnd.spacecraft.util;

import api.util.BlockPos;
import api.util.BlockPosUtils;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpacecraftBuilder {

    private final ArrayList<Long> blockKeys = new ArrayList<>();
    private final ArrayList<Integer> blockValues = new ArrayList<>();
    private final HashMap<Long, TileEntity> entities = new HashMap<>();

    private BlockPos minPos = BlockPos.ORIGIN;
    private BlockPos maxPos = BlockPos.ORIGIN;

    public void setBlockState(BlockPos pos, Block block, int meta) {
        this.updateBounds(pos);

        long newPos = BlockPos.chunkXYZ2Long(pos);
        this.blockKeys.add(newPos);
        this.blockValues.add(Block.getIdFromBlock(block) | (meta << 12));
    }

    public void setTileEntity(BlockPos pos, TileEntity tileEntity) {
        this.updateBounds(pos);

        long newPos = BlockPos.chunkXYZ2Long(pos);
        this.entities.put(newPos, tileEntity);
    }

    private void updateBounds(BlockPos pos) {
        this.minPos = BlockPosUtils.min(new BlockPos((int)pos.getX(), (int)pos.getY(), (int)pos.getZ()), this.minPos);
        this.maxPos = BlockPosUtils.max(new BlockPos((int)pos.getX(), (int)pos.getY(), (int)pos.getZ()), this.maxPos);
    }

    public SpacecraftBuilder copyFrom(World world, BlockPos origin, SpacecraftBlueprint positions) {

        if (positions == null) {
            return this;
        }

        List<BlockPos> locations = Lists.newArrayList(positions.getPositions());

        for(BlockPos pos : locations) {

            BlockPos localPos = new BlockPos(pos.getX() - origin.getX(), pos.getY() - origin.getY(), pos.getZ() - origin.getZ());
            Block block = world.getBlock((int) pos.getX(), (int) pos.getY(), (int) pos.getZ());
            int meta = world.getBlockMetadata((int) pos.getX(), (int) pos.getY(), (int) pos.getZ());
            this.setBlockState(localPos, block, meta);

            TileEntity entity = world.getTileEntity((int) pos.getX(), (int) pos.getY(), (int) pos.getZ());
            if(entity != null) {

                NBTTagCompound tag = new NBTTagCompound();
                entity.writeToNBT(tag);
                tag.setLong("x", localPos.getX());
                tag.setLong("y", localPos.getY());
                tag.setLong("z", localPos.getZ());
                TileEntity copiedEntity = TileEntity.createAndLoadEntity(tag);

                if(copiedEntity == null) {
                    System.out.println("Failed to copy TE when building spacecraft");
                    continue;
                }

                this.setTileEntity(localPos, copiedEntity);

            }
        }

        return this;

    }

    public SpacecraftBodyData buildBodyData(BlockPos origin, World world) {

        int[] blockData = new int[SpacecraftBodyData.getDataSize(minPos, maxPos)];

        for (int i = 0; i < this.blockKeys.size(); i++) {

            BlockPos pos = BlockPos.fromLong(this.blockKeys.get(i));
            int state = this.blockValues.get(i);

            blockData[SpacecraftBodyData.getPosIndex(pos, minPos, maxPos)] = state;

        }

        return new SpacecraftBodyData(blockData, this.entities, minPos, maxPos);

    }
}
