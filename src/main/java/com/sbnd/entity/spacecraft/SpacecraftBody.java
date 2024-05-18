package com.sbnd.entity.spacecraft;


import api.spacecraft.ISpacecraft;
import api.spacecraft.ISpacecraftBodyData;
import api.util.BlockPos;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;

public class SpacecraftBody {

    // Here you put all the funny rotation stuff
    // But I'm not doing that rn

    public final World world;
    public final ISpacecraftBodyData data;

    @SideOnly(Side.CLIENT)
    public SpacecraftModel model;


    public SpacecraftBody(World parent, ISpacecraftBodyData data) {
        this.data = data;
        this.world = parent;
        if (world.isRemote) {
            this.model = SpacecraftModel.build(data);
        }
    }

    public SpacecraftBody(ISpacecraft spacecraft) {
        this(spacecraft.getWorld(), spacecraft.buildBodyData(spacecraft.getWorld()));
    }

    public BlockPos getMinPos() {
        return data.getMinPos();
    }

    public BlockPos getMaxPos() {
        return data.getMaxPos();
    }


}
