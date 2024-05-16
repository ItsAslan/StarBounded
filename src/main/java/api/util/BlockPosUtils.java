package api.util;

public class BlockPosUtils {

    public static BlockPos min(BlockPos a, BlockPos b) {
        return new BlockPos(Math.min(a.x, b.x), Math.min(a.y, b.y), Math.min(a.z, b.z));
    }

    public static BlockPos max(BlockPos a, BlockPos b) {
        return new BlockPos(Math.max(a.x, b.x), Math.max(a.y, b.y), Math.max(a.z, b.z));
    }

}