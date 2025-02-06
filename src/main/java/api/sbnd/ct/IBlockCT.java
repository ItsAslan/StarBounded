package api.sbnd.ct;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public interface IBlockCT {

    default boolean canConnect(IBlockAccess world, int x, int y, int z, Block block) {
        return block.getClass() == getClass();
    }

}
