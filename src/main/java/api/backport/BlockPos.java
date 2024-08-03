package api.backport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.util.EnumFacing;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class BlockPos {

    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);

    private final int x;
    private final int y;
    private final int z;

    public static BlockPos min(BlockPos a, BlockPos b) {

        return new BlockPos(
                Math.min(a.getX(), b.getX()),
                Math.min(a.getY(), b.getY()),
                Math.min(a.getZ(), b.getZ())
        );

    }

    public static BlockPos max(BlockPos a, BlockPos b) {

        return new BlockPos(
                Math.max(a.getX(), b.getX()),
                Math.max(a.getY(), b.getY()),
                Math.max(a.getZ(), b.getZ())
        );

    }

    public static BlockPos fromLong(long value) {

        int x = (int) (value >> 38);
        int y = (int) (value << 52 >> 52);
        int z = (int) (value << 26 >> 38);
        return new BlockPos(x, y, z);

    }

    public long toLong() {
        return ((long)x & 0xFFFFFFFFL) | (((long)y & 0xFFFFFFFFL) << 32) | (((long)z & 0xFFFFFFFFL) << 16);
    }

    public static long chunkXYZ2Long(BlockPos pos) {
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

}
