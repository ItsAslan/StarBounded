package api.interfaces.multiblock.base;

import com.sbnd.blocks.multiblock.base.ControllerBase;

public interface IMultiblockModule {

    ControllerBase getController();

    void setController(ControllerBase controller);

}
