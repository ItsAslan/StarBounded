package api.interfaces.energy;

import api.util.BlockPos;
import com.sbnd.energy.EnergyNetwork;
import com.sbnd.main.Starbounded;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyComponent {

    boolean hasNetwork();
    EnergyNetwork getNetwork();
    void joinNetwork(EnergyNetwork net);

    default void linkNetworks(EnergyNetwork net1, EnergyNetwork net2) {
        Starbounded.NETWORKHANDLER.linkNetworks(net1, net2);
    }

    default void scan(World world, BlockPos pos) {

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

            TileEntity te = world.getTileEntity((int) pos.getX() + dir.offsetX , (int) pos.getY() + dir.offsetY,  (int) pos.getZ() + dir.offsetZ);

            if(te == null) {
                continue;
            }

            if(te instanceof IEnergyComponent) {

                IEnergyComponent component = (IEnergyComponent) te;

                if(component.hasNetwork() && !hasNetwork()) {

                    joinNetwork(component.getNetwork());

                } else if (hasNetwork() && component.hasNetwork()) {

                    linkNetworks(component.getNetwork(), getNetwork());

                }

            }

        }

        if(!hasNetwork()) {

            Starbounded.NETWORKHANDLER.createNetwork(this);

        }

    }

}
