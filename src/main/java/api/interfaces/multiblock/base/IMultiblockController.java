package api.interfaces.multiblock.base;

import com.sbnd.blocks.multiblock.base.ModuleBase;

public interface IMultiblockController {

    void newBlockAdded(ModuleBase block);

    void tick();

}
