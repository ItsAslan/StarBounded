package api.spacecraft;

import api.util.interfaces.IUnique;

public interface ISpacecraftModule extends IUnique
{
    ISpacecraft getOwner();
}
