package com.sbnd.entity.spacecraft;

import api.util.BlockPos;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySpacecraft extends Entity implements IEntityAdditionalSpawnData {

    public static final double TEST_AIR_RESISTANCE = 0.98;
    public static final double TEST_GRAVITY = 1.6;


    private SpacecraftBody body;
    @SideOnly(Side.CLIENT)
    public SpacecraftModel model;

    public EntitySpacecraft(World world) {

    }

    public EntitySpacecraft(World world, SpacecraftBlueprint positions, BlockPos origin) {

    }


    @Override
    public void writeSpawnData(ByteBuf buffer) {

    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {

    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }
}
