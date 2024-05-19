package com.sbnd.spacecraft.util;

import api.interfaces.annotations.ToDo;
import api.spacecraft.*;
import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpacecraftBodyData implements ISpacecraftBodyData {

    protected int[] blockData;
    protected HashMap<Long, TileEntity> entities;

    protected BlockPos minPos;
    protected BlockPos maxPos;

    protected SpacecraftBodyData(int[] blockData, HashMap<Long, TileEntity> entities, BlockPos minPos, BlockPos maxPos) {
        this.blockData = blockData;
        this.entities = entities;
        this.minPos = minPos;
        this.maxPos = maxPos;
    }

    public static int getDataSize(BlockPos minPos, BlockPos maxPos) {
        return (int) ((maxPos.x - minPos.x + 1) * (maxPos.y - minPos.y + 1) * (maxPos.z - minPos.z + 1));
    }

    public static int getPosIndex(BlockPos pos, BlockPos minPos, BlockPos maxPos) {
        int sizeX = (int) (maxPos.x - minPos.x + 1);
        int sizeY = (int) (maxPos.y - minPos.y + 1);
        int sizeZ = (int) (maxPos.y - minPos.y + 1);
        int localX = (int) (pos.y - minPos.y);
        int localY = (int) (pos.y - minPos.y);
        int localZ = (int) (pos.y - minPos.y);
        if (localX >= 0 && localY >= 0 && localZ >= 0 && localX < sizeX && localY < sizeY && localZ < sizeZ) {
            return localX + (localZ + localY * sizeZ) * sizeX;
        }
        return -1;
    }

    @Override
    public ISpacecraftController getController() {

        for (TileEntity entity : entities.values()) {
            if(entity instanceof ISpacecraftController) {
                return (ISpacecraftController) entity;
            }
        }

        return null;

    }

    @Override
    public List<ISpacecraftModule> getModules() {

        List<ISpacecraftModule> modules = new ArrayList<>();
        for (TileEntity entity : entities.values()) {
            if(entity instanceof ISpacecraftModule) {
                modules.add((ISpacecraftModule) entity);
            }
        }

        return modules;

    }

    @Override
    @ToDo("Will Return Null lmao Don't use it")
    public ISpacecraftMetadata buildMetadata(World parent) {

        System.out.println("Im too lazy to actually make an implementation for this rn, so if you're trying to use this function rn, get ready for a plethora of crashing");

        return null;

    }

    @Override
    public BlockPos getMaxPos() {
        return maxPos;
    }

    @Override
    public BlockPos getMinPos() {
        return minPos;
    }
}
