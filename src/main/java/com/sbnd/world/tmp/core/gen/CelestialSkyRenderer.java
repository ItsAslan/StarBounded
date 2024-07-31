package com.sbnd.world.tmp.core.gen;

import com.sbnd.main.SbndUtil;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import com.sbnd.world.tmp.core.bodies.Star;
import com.sbnd.world.tmp.core.gen.util.Color4;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Random;

public class CelestialSkyRenderer extends IRenderHandler {

    private final ArrayList<ResourceLocation> bodyIcons = new ArrayList<>();
    private final Star star;
    private final Color4 fogColor;

    public CelestialSkyRenderer(ArrayList<CelestialBody> bodies, Star star, Color4 fogColor) {

        bodies.forEach(icon -> bodyIcons.add(icon.getIcon()));

        this.star = star;
        this.fogColor = fogColor;

    }

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) {

        renderBodies(bodyIcons);
        renderSun(star);
        renderSkybox(SbndUtil.STAR_COUNT, SbndUtil.STAR_SEED);
        renderFog(fogColor);

    }

    private void renderBodies(ArrayList<ResourceLocation> bodyIcons) {

        ;

    }

    private void renderSun(Star star) {

        ;

    }

    private void renderSkybox(int numStar, long seed) {

        Random random = new Random(seed);

        GL11.glEnable(GL11.GL_POINT_SMOOTH);
        GL11.glPointSize(2.0F);
        GL11.glBegin(GL11.GL_POINTS);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);

        for (int i = 0; i < numStar; ++i) {

            double x = random.nextFloat() * 2.0F - 1.0F;
            double y = random.nextFloat() * 2.0F - 1.0F;
            double z = random.nextFloat() * 2.0F - 1.0F;
            double distance = Math.sqrt(x * x + y * y + z * z);

            if (distance < 1.0D && distance > 0.01D) {

                x /= distance;
                y /= distance;
                z /= distance;
                double scale = 100.0 + random.nextDouble() * 50.0;

                GL11.glVertex3d(x * scale, y * scale, z * scale);

            }

        }

        GL11.glEnd();
        GL11.glDisable(GL11.GL_POINT_SMOOTH);

    }

    private void renderFog(Color4 color) {

        ;

    }

    //------------------------------------------------------//

    private void resetGL() {

        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glPopMatrix();

    }

}
