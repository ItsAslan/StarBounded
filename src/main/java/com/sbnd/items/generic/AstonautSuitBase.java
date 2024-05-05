package com.sbnd.items.generic;

import api.interfaces.space.ISpaceSuit;

public class AstonautSuitBase extends ArmorGeneric implements ISpaceSuit
{

    private double currentOxygen = 0;

    public AstonautSuitBase(ArmorMaterial material, int renderIndex, int armorType, String root) {
        super(material, renderIndex, armorType, root);
    }

    @Override
    public boolean isFireResistant() {
        return false;
    }

    @Override
    public double radiationAbsorption() {
        return 0;
    }
}
