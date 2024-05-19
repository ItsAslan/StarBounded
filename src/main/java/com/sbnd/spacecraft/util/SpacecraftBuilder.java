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
        this.minPos = BlockPosUtils.min(new BlockPos((int)pos.x, (int)pos.y, (int)pos.z), this.minPos);
        this.maxPos = BlockPosUtils.max(new BlockPos((int)pos.x, (int)pos.y, (int)pos.z), this.maxPos);
    }

    public SpacecraftBuilder copyFrom(World world, BlockPos origin, SpacecraftBlueprint positions) {

        if (positions == null) {
            return this;
        }

        List<BlockPos> locations = Lists.newArrayList(positions.getPositions());

        for(BlockPos pos : locations) {

            BlockPos localPos = new BlockPos(pos.x - origin.x, pos.y - origin.y, pos.z - origin.y);
            Block block = world.getBlock((int) pos.x, (int) pos.y, (int) pos.z);
            int meta = world.getBlockMetadata((int) pos.x, (int) pos.y, (int) pos.z);
            this.setBlockState(localPos, block, meta);

            TileEntity entity = world.getTileEntity((int) pos.x, (int) pos.y, (int) pos.z);
            if(entity != null) {

                NBTTagCompound tag = new NBTTagCompound();
                entity.writeToNBT(tag);
                tag.setLong("x", localPos.x);
                tag.setLong("y", localPos.y);
                tag.setLong("z", localPos.z);
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
