package com.sbnd.world.celestial.core.base;

import com.sbnd.world.celestial.core.data.IWorldData;
import lombok.Getter;
import net.minecraft.world.WorldProvider;

public class WorldProviderCelestial extends WorldProvider {

    @Getter
    private final IWorldData data;

    public WorldProviderCelestial(IWorldData data) {
        this.data = data;
    }

    @Override
    public String getDimensionName() {
        return data.getName();
    }

}
