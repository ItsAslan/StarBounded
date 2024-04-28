package api.interfaces.multiblock.chemplant;

public interface IChemplantModule
{

    boolean isFluidContainer();

    void setController(IChemplantController controller);
    IChemplantController getController();

}
