package com.sbnd.items.generic;

import api.interfaces.generic.ISpaceSuit;
import lombok.Getter;

public class AstonautSuitBase extends ArmorGeneric implements ISpaceSuit
{

    @Getter
    private double currentOxygen = 100;

    public AstonautSuitBase(ArmorMaterial material, int renderIndex, int armorType, String root) {
        super(material, renderIndex, armorType, root);
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public double radiationAbsorption() {
        return 50;
    }
}
