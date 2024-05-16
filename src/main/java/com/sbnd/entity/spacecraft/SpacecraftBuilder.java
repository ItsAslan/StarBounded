package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraftBodyData;
import api.util.BlockPos;
import api.util.BlockPosUtils;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpacecraftBuilder {

    private final ArrayList<Long> blockKeys = new ArrayList<>();
    private final ArrayList<Integer> blockValues = new ArrayList<>();
    private final HashMap<Long, TileEntity> entities = new HashMap<>();

    private ChunkCoordinates minPos = new ChunkCoordinates(0, 0, 0);
    private ChunkCoordinates maxPos = new ChunkCoordinates(0, 0, 0);

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
        this.minPos = BlockPosUtils.min(new ChunkCoordinates((int)pos.x, (int)pos.y, (int)pos.z), this.minPos);
        this.maxPos = BlockPosUtils.max(new ChunkCoordinates((int)pos.x, (int)pos.y, (int)pos.z), this.maxPos);
    }

    public SpacecraftBuilder copyFrom(World world, BlockPos origin, SpacecraftBlueprint positions) {

        if (positions == null) {
            return this;
        }

        List<ChunkCoordinates> locations = Lists.newArrayList(positions.getPositions());

        for(ChunkCoordinates pos : locations) {

            BlockPos localPos = new BlockPos(pos.posX - origin.x, pos.posY - origin.y, pos.posY - origin.y);
            Block block = world.getBlock(pos.posX, pos.posY, pos.posZ);
            int meta = world.getBlockMetadata(pos.posX, pos.posY, pos.posZ);
            this.setBlockState(localPos, block, meta);

            TileEntity entity = world.getTileEntity(pos.posX, pos.posY, pos.posZ);
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

        for(int i = 0; i < this.blockKeys.size(); i++) {
            long pos = this.blockKeys.get(i);
            int x = (int) (pos >> 38);
            int y = (int) ((pos >> 26) & 0xFFF);
            int z = (int) (pos & 0x3FFFFFF);
            int state = this.blockValues.get(i);

            blockData[SpacecraftBodyData.getPosIndex(x, y, z, minPos, maxPos)] = state;
        }

        int[] lightData = new int[SpacecraftBodyData.getDataSize(minPos, maxPos)];
        for(int x = minPos.posX; x <= maxPos.posX; x++) {

            for(int y = minPos.posY; y <=maxPos.posY; y++) {

                for(int z = minPos.posZ; z <= maxPos.posZ; z++) {

                    int index = SpacecraftBodyData.getPosIndex(x, y, z, minPos, maxPos);
                    lightData[index] = getCombinedLight(world, (int) (x + origin.x), (int) (y + origin.y), (int) (z + origin.z));

                }

            }

        }

        BiomeGenBase biome = world.getBiomeGenForCoords((int)origin.x, (int)origin.z);

        return new SpacecraftBodyData(blockData, lightData, this.entities, biome, minPos, maxPos);

    }

    private int getCombinedLight(World world, int x, int y, int z) {
        int skyLight = getLightFromNeighborsFor(world, EnumSkyBlock.Sky, x, y, z);
        int blockLight = getLightFromNeighborsFor(world, EnumSkyBlock.Block, x, y, z);
        return skyLight << 20 | blockLight << 4;
    }

    private int getLightFromNeighborsFor(World world, EnumSkyBlock type, int x, int y, int z) {
        if (world.provider.hasNoSky || type != EnumSkyBlock.Sky) {
            y = Math.max(0, y);
            if (world.checkChunksExist(x, y, z, x, y, z)) {
                if (world.getBlock(x, y, z).getLightValue() > 0) {
                    int u = getLightForSide(world, type, x, y + 1, z, 1);
                    int n = getLightForSide(world, type, x, y, z - 1, 2);
                    int s = getLightForSide(world, type, x, y, z + 1, 3);
                    int w = getLightForSide(world, type, x - 1, y, z, 4);
                    int e = getLightForSide(world, type, x + 1, y, z, 5);
                    return Math.max(u, Math.max(e, Math.max(w, Math.max(s, n))));
                }
                Chunk chunk = world.getChunkFromBlockCoords(x, z);
                return chunk.getSavedLightValue(type, x & 15, y, z & 15);
            } else return type.defaultLightValue;
        }
        return 0;
    }

    private int getLightForSide(World world, EnumSkyBlock type, int x, int y, int z, int side) {
        if (side == 1) y++;
        else if (side == 2) z--;
        else if (side == 3) z++;
        else if (side == 4) x--;
        else if (side == 5) x++;

        boolean invalidY = y < 0;
        int light;
        if (invalidY) y = 0;
        if (world.checkChunksExist(x, y, z, x, y, z)) {
            Chunk chunk = world.getChunkFromBlockCoords(x, z);
            light = chunk.getSavedLightValue(type, x & 15, y, z & 15);
        } else light = type.defaultLightValue;
        return light;
    }

}
