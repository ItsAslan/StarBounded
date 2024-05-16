package api.util;

import java.util.Objects;

public class BlockPos
{

    public long x;
    public long y;
    public long z;

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

    public static long chunkXYZ2Long(BlockPos pos) {
        // I swear it won't hurt you
        return ((long)pos.x & 0x3FFFFFF) << 38 | ((long)pos.y & 0xFFF) << 26 | ((long)pos.z & 0x3FFFFFF);
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
