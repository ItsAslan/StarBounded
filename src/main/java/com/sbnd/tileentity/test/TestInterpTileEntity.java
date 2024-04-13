package com.sbnd.tileentity.test;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TestInterpTileEntity extends TileEntity
{

    private boolean isActive = false;
    private float currentHeight = 0.0f;
    private float maxHeight = 100.0f;
    private float interpAmount = 0.1f;

    public void setActive(boolean set)
    {
        this.isActive = set;
    }

    public boolean getActive()
    {
        return this.isActive;
    }

    public float getCurrentHeight()
    {
        return this.currentHeight;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(getActive())
        {
            if(maxHeight >= currentHeight)
            {
                int x = this.xCoord;
                int y = this.yCoord;
                int z = this.zCoord;

                this.currentHeight += interpAmount;
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

            }
            else
            {
                setActive(false);
            }
        }

        markDirty();
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        currentHeight = compound.getFloat("currentHeight");
        isActive = compound.getBoolean("isActive");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setFloat("currentHeight", currentHeight);
        compound.setBoolean("isActive", isActive);
    }
}
