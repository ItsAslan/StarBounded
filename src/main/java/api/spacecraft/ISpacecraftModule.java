package api.spacecraft;

import api.util.IUnique;

public interface ISpacecraftModule extends IUnique
{
    public ISpacecraft getOwner();
}
