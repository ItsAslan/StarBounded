package api.sbnd.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.util.EnumFacing;

@AllArgsConstructor
public class BlockPos {

    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);

    @Setter @Getter private int x;
    @Setter @Getter private int y;
    @Setter @Getter private int z;

    public BlockPos offset(EnumFacing facing) {

        return new BlockPos(
                getX() + facing.getFrontOffsetX(),
                getY() + facing.getFrontOffsetY(),
                getZ() + facing.getFrontOffsetZ()
        );

    }

    public BlockPos offset(EnumFacing facing, int n) {

        return new BlockPos(
                getX() + facing.getFrontOffsetX() * n,
                getY() + facing.getFrontOffsetY() * n,
                getZ() + facing.getFrontOffsetZ() * n
        );

    }

}
