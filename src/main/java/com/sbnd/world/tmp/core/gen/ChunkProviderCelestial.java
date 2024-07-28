package com.sbnd.world.tmp.core.gen;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.List;

public class ChunkProviderCelestial implements IChunkProvider {

    @Override
    public boolean chunkExists(int x, int y) {
        return false;
    }

    @Override
    public Chunk provideChunk(int x, int y) {
        return null;
    }

    @Override
    public Chunk loadChunk(int x, int y) {
        return null;
    }

    @Override
    public void populate(IChunkProvider provider, int x, int y) {

    }

    @Override
    public boolean saveChunks(boolean bool, IProgressUpdate update) {
        return false;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return false;
    }

    @Override
    public String makeString() {
        return null;
    }

    // I think this returns entity
    @Override
    public List<Entity> getPossibleCreatures(EnumCreatureType creatureType, int x, int y, int zy) {
        return null;
    }

    //  ¯\_(ツ)_/¯
    @Override
    public ChunkPosition func_147416_a(World world, String structureName, int x, int y, int z) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(int x, int y) {

    }

    @Override
    public void saveExtraData() {

    }

}
