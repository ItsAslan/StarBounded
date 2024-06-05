package api.interfaces.multiblock.base;

import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public interface IMultiblockController {

    List<IMultiblockModule> getModules();
    default void delete() { // Handles controller deletion

        List<IMultiblockModule> modulesToRemove = new ArrayList<>(getModules());

        for(IMultiblockModule module : modulesToRemove) {
            module.unlinkModule();
        }

    }
    default void pingController(World world, BlockPos pos) {

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if(te instanceof IMultiblockModule) {

                IMultiblockModule module = (IMultiblockModule) te;

                module.moduleScan(world, pos);

            }

        }

    }
    void tick();

}
