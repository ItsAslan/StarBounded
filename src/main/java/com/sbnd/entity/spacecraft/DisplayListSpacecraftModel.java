package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraftBodyData;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public class DisplayListSpacecraftModel implements SpacecraftModel {

    private final ISpacecraftBodyData data;
    private final Map<Integer, Integer> lists = new HashMap<>();
    private boolean available = true;

    public DisplayListSpacecraftModel(ISpacecraftBodyData data) {

        this.data = data;

        for (int pass = 0; pass < 2; pass++) {

            drawBlocks(data, pass);

            int id = GLAllocation.generateDisplayLists(1);

            GL11.glNewList(id, GL11.GL_COMPILE);
            Tessellator.instance.draw();
            GL11.glEndList();

            this.lists.put(pass, id);

        }

    }

    @Override
    public void render(int layer) {

        if(!this.available) {
            throw new IllegalStateException("Cannot render spacecraft after display list has been deleted :(");
        }

        int list = this.lists.get(layer);
        GL11.glCallList(list);

    }

    @Override
    public void delete() {

        this.available = false;

        for(int id : this.lists.values()) {
            GLAllocation.deleteDisplayLists(id);
        }

    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public ISpacecraftBodyData getBody() {
        return this.data;
    }

    protected void finalize() {

        if (this.available) {
            this.delete();
        }

    }
}
