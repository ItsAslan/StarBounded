package com.sbnd.spacecraft.entity;

import api.spacecraft.ISpacecraft;
import api.spacecraft.ISpacecraftMetadata;
import api.util.BlockPos;
import com.sbnd.spacecraft.render.SpacecraftModel;
import com.sbnd.spacecraft.util.SpacecraftBlueprint;
import com.sbnd.spacecraft.util.SpacecraftBody;
import com.sbnd.spacecraft.util.SpacecraftBuilder;
import com.sbnd.main.Starbounded;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySpacecraft extends Entity implements IEntityAdditionalSpawnData {

    public static final double BASE_AIR_RESISTANCE = 0.98;
    public static final double GRAVITY = 1.6;

    private SpacecraftBody body;

    @SideOnly(Side.CLIENT)
    public SpacecraftModel model;

    private boolean converted;
    private ISpacecraftMetadata metadata;

    private ISpacecraft spacecraft;

    public EntitySpacecraft(World world) {
        this(world, null, BlockPos.ORIGIN, null);
    }

    public EntitySpacecraft(World world, SpacecraftBlueprint positions, BlockPos origin, ISpacecraft parent) {
        super(world);
        this.setSize(1, 1);

        SpacecraftBuilder builder = new SpacecraftBuilder();
        builder.copyFrom(world, origin, positions);
        this.body = new SpacecraftBody(world, builder.buildBodyData(origin, world));

        if (parent != null) {
            entityInit();
        }

    }

    public EntitySpacecraft(ISpacecraft spacecraft) {
        super(spacecraft.getWorld());
        this.setSize(1, 1);

        this.body = new SpacecraftBody(spacecraft);

        entityInit();
    }

    @Override
    public void onUpdate() {
        double airResistance = BASE_AIR_RESISTANCE;
        this.motionX *= airResistance;
        this.motionY *= airResistance;
        this.motionZ *= airResistance;

        this.motionY -= GRAVITY / 20.0;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer) {
        // Naw uh
    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {
        // Naw uh
    }

    @Override
    protected void entityInit() {
        if (!worldObj.isRemote) {
            Starbounded.PROXY.getSpacecraftManager().registerSpacecraft(spacecraft);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        // Yap Yap
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        // Yap Yap
    }
}
