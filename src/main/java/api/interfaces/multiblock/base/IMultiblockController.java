package api.interfaces.multiblock.base;

import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public interface IMultiblockController {

    List<IMultiblockModule> getModules();
    BlockPos getPos();
    ArrayList<ForgeDirection> getValidDirections();
    default void delete() { // Handles controller deletion

        List<IMultiblockModule> modulesToRemove = new ArrayList<>(getModules());

        for(IMultiblockModule module : modulesToRemove) {
            module.notifyControllerDeletion();
            System.out.println("Deleted: " + module);
        }

    }
    default void pingController(World world, BlockPos pos, ArrayList<ForgeDirection> validDirections) {

        // Use this instead of the `.clear()` method because 'delete()' actually unlinks the modules
        delete();

        for(ForgeDirection dir : validDirections) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if(te instanceof IMultiblockModule) {

                IMultiblockModule module = (IMultiblockModule) te;

                if(!te.isInvalid()) {
                    module.moduleScan(world, module.getPos(), module.getValidDirections());
                }

            }

        }

    }
    void tick();

}