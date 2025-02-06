package api.sbnd.interfaces;

import javax.annotation.Nullable;

public interface ISpacecraftModule extends IUnique {

    void setOwner(@Nullable ISpacecraft controller);

    @Nullable
    ISpacecraft getOwner();

    String getName();

}
