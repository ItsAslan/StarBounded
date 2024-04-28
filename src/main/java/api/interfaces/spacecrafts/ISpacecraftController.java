package api.interfaces.spacecrafts;

import api.enums.EnumControllerType;

public interface ISpacecraftController extends ISpacecraftModule
{
    EnumControllerType getControllerType();
}
