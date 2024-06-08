package api.interfaces.multiblock.base;

import api.util.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public interface IMultiblockModule {

    IMultiblockController getController();
    BlockPos getPos();
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

                if(!module.hasController() && hasController()) {

                    module.setController(getController());
                    module.moduleScan(world, ((IMultiblockModule) te).getPos());

                }
                else if(module.hasController() && !hasController()) {
                    setController(module.getController());
                    module.moduleScan(world, ((IMultiblockModule) te).getPos());
                }

            }
            else if (te instanceof IMultiblockController) {

                IMultiblockController controller = (IMultiblockController) te;

                if(!hasController()) {
                    setController(controller);
                }
                //controller.pingController(world, pos);

            }

        }

    }

}