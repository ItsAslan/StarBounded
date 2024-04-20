package com.sbnd.interfaces.spacecrafts;

import com.sbnd.enums.EnumControllerType;

public interface ISpacecraftController extends ISpacecraftModule
{
    EnumControllerType getControllerType();
}
