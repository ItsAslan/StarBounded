package api.util;

import lombok.Getter;
import net.minecraft.util.EnumFacing;

import java.util.Objects;

public class BlockPos
{

    @Getter
    private long x;
    @Getter
    private long y;
    @Getter
    private long z;

    public BlockPos(long x, long y, long z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long toLong() {
        // What the fuck?
        return ((long)x & 0xFFFFFFFFL) | (((long)y & 0xFFFFFFFFL) << 32) | (((long)z & 0xFFFFFFFFL) << 16);
    }

    public static BlockPos fromLong(long value) {
        // I just want to talk to him, I just want to talk to him
        int x = (int) (value >> 38);
        int y = (int) (value << 52 >> 52);
        int z = (int) (value << 26 >> 38);
        return new BlockPos(x, y, z);
    }

    public static long chunkXYZ2Long(BlockPos pos) {
        // I swear it won't hurt you
        return ((long)pos.x & 0x3FFFFFF) << 38 | ((long)pos.y & 0xFFF) << 26 | ((long)pos.z & 0x3FFFFFF);
    }

    public BlockPos offset(EnumFacing facing) {
        switch (facing) {
            case DOWN: return new BlockPos(x, y - 1, z);
            case UP: return new BlockPos(x, y + 1, z);
            case NORTH: return new BlockPos(x, y, z - 1);
            case SOUTH: return new BlockPos(x, y, z + 1);
            case WEST: return new BlockPos(x - 1, y, z);
            case EAST: return new BlockPos(x + 1, y, z);
            default: return this;
        }
    }

    public String toString()
    {
        return String.format("(%d, %d, %d)", this.x, this.y, this.z);
    }

    public long[] toArray()
    {
        return new long[] {this.x, this.y, this.z};
    }

    public int hashCode()
    {
        return Objects.hash(this.x, this.y, this.z);
    }

    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);

}
