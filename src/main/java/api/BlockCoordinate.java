package api;

import java.util.Objects;

public class BlockCoordinate
{

    public long x;
    public long y;
    public long z;

    public BlockCoordinate(long x, long y, long z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
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
