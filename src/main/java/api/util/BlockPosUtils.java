package api.util;

import net.minecraft.util.ChunkCoordinates;

public class BlockPosUtils {

    public static ChunkCoordinates min(ChunkCoordinates a, ChunkCoordinates b) {
        return new ChunkCoordinates(Math.min(a.posX, b.posX), Math.min(a.posY, b.posY), Math.min(a.posZ, b.posZ));
    }

    public static ChunkCoordinates max(ChunkCoordinates a, ChunkCoordinates b) {
        return new ChunkCoordinates(Math.max(a.posX, b.posX), Math.max(a.posY, b.posY), Math.max(a.posZ, b.posZ));
    }

}