package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraftBodyData;
import api.spacecraft.ISpacecraftController;
import api.spacecraft.ISpacecraftMetadata;
import api.spacecraft.ISpacecraftModule;
import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.HashMap;
import java.util.List;

public class SpacecraftBodyData implements ISpacecraftBodyData {

    protected int[] blockData;
    protected int[] lightData;
    protected HashMap<Long, TileEntity> entities;

    protected BiomeGenBase biome;

    protected ChunkCoordinates minPos;
    protected ChunkCoordinates maxPos;


    protected SpacecraftBodyData(int[] blockData, int[] lightData, HashMap<Long, TileEntity> entities, BiomeGenBase biome, ChunkCoordinates minPos, ChunkCoordinates maxPos) {
        this.blockData = blockData;
        this.lightData = lightData;
        this.entities = entities;
        this.biome = biome;
        this.minPos = minPos;
        this.maxPos = maxPos;
    }

    public static int getDataSize(ChunkCoordinates minPos, ChunkCoordinates maxPos) {
        return 0;
    }

    public static int getPosIndex(int x, int y, int z, ChunkCoordinates minPos, ChunkCoordinates maxPos) {
        return 0;
    }

    @Override
    public ISpacecraftController getController() {
        return null;
    }

    @Override
    public List<ISpacecraftModule> getModules() {
        return null;
    }

    @Override
    public ISpacecraftMetadata buildMetadata(World parent) {
        return null;
    }

    @Override
    public BlockPos getMaxPos() {
        return null;
    }

    @Override
    public BlockPos getMinPos() {
        return null;
    }
}
