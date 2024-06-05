package api.interfaces.multiblock.base;

import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public interface IMultiblockModule {

    IMultiblockController getController();
    void setController(IMultiblockController controller);
    boolean hasController();
    void linkModule(); // Appends it to the `connectedModules` ArrayList in the controller
    void unlinkModule();
    default void moduleScan(World world, BlockPos pos) {

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if(te instanceof IMultiblockModule) {

                IMultiblockModule module = (IMultiblockModule) te;

                if(module.hasController()) {

                    setController(module.getController());
                    module.getController().pingController(world, pos);
                    break;

                }

            }
            else if (te instanceof IMultiblockController) {

                IMultiblockController controller = (IMultiblockController) te;

                setController(controller);
                controller.pingController(world, pos);
                break;

            }

        }

    }

}
