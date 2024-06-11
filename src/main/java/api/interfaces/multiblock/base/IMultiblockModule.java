package api.interfaces.multiblock.base;

import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public interface IMultiblockModule {

    IMultiblockController getController();
    BlockPos getPos();
    ArrayList<ForgeDirection> getValidDirections();
    void setController(IMultiblockController controller);
    boolean hasController();
    void linkModule(); // Appends it to the `connectedModules` ArrayList in the controller
    void unlinkModule();
    void notifyControllerDeletion();
    default void moduleScan(World world, BlockPos pos, ArrayList<ForgeDirection> validDirections) {

        controllerScan(world, pos, validDirections);

        for(ForgeDirection dir : validDirections) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if(te instanceof IMultiblockModule) {

                IMultiblockModule module = (IMultiblockModule) te;

                if(!module.hasController() && hasController()) {

                    module.setController(getController());
                    module.moduleScan(world, ((IMultiblockModule) te).getPos(), validDirections);

                }

            }

        }

    }

    default void controllerScan(World world, BlockPos pos, ArrayList<ForgeDirection> validDirections) {

        for(ForgeDirection dir : validDirections) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if (te instanceof IMultiblockController) {

                IMultiblockController controller = (IMultiblockController) te;

                if(!hasController()) {
                    setController(controller);

                    break;
                }

            }
            else if(te instanceof IMultiblockModule) {

                IMultiblockModule module = (IMultiblockModule) te;

                if(module.hasController() && !hasController()) {
                    setController(module.getController());

                    break;
                }

            }

        }

    }

}