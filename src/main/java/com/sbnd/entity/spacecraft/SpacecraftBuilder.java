package com.sbnd.entity.spacecraft;

import api.interfaces.annotations.ToDo;
import api.util.BlockPos;
import api.util.BlockPosUtils;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.*;

public class SpacecraftBuilder
{

    private Set<Long> blockKeys = new HashSet<>();
    private Set<Integer> blockValues = new HashSet<>();
    private final Map<Long, TileEntity> entities = new HashMap<>();


    private BlockPos minPos = BlockPos.ORIGIN;
    private BlockPos maxPos = BlockPos.ORIGIN;

    public void setBlockState(BlockPos pos, Block block, int metadata) {
        this.updateBounds(pos);

        this.blockKeys.add(pos.toLong());
        int blockStateId = Block.getIdFromBlock(block) | (metadata << 12);
        this.blockValues.add(blockStateId);
    }

    public void setTileEntity(BlockPos pos, TileEntity entity) {
        this.updateBounds(pos);

        this.entities.put(pos.toLong(), entity);
    }

    public void updateBounds(BlockPos pos) {
        this.minPos = BlockPosUtils.min(pos, this.minPos);
        this.maxPos = BlockPosUtils.min(pos, this.maxPos);
    }

    @ToDo("asjd")
    public SpacecraftBuilder copyFrom(World world, BlockPos origin, SpacecraftBlueprint positions) {

        if(positions == null) {
            return this;
        }

        // List<BlockPos> locations = Lists.newArrayList(positions.getPositions());

        return null;
    }


}
