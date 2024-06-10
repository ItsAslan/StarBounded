package com.sbnd.tileentity.machine.mixer;

import com.sbnd.tileentity.machine.base.BaseMultiblockControllerTE;
import lombok.Getter;
import lombok.Setter;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Arrays;

public class MixerControllerTE extends BaseMultiblockControllerTE {

    @Getter
    @Setter
    ArrayList<ForgeDirection> validConnections = new ArrayList<>(Arrays.asList(ForgeDirection.UP, ForgeDirection.DOWN));

    @Override
    public ArrayList<ForgeDirection> getValidDirections() {
        return getValidConnections();
    }

}
