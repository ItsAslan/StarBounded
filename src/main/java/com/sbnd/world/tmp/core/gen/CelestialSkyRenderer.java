package com.sbnd.world.tmp.core.gen;

import com.sbnd.main.SbndUtil;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import com.sbnd.world.tmp.core.bodies.Star;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.ArrayList;
import java.util.Random;

// This is a custom class for rendering the sky for any given `CelestialBody`

// The state the renderer is in right now is very primitive and is subject to substantial change.
// Currently, the renderer renders:
//      Single Star
//      Single Parent Planet
//      Stars In Sky

// The renderer won't work in this state, for sizes are arbitrary numbers, icon loading
// is not implemented, and the code is overall not optimized.

// The renderer will support (basically a to-do list for the next few commits):
//      Automatic Primary Planet Rendering
//      Automatic Star Rendering
//      Automatic Size Calculations Based on Distance From Body
//      Cool Graphics (Glare, Bloom, Glow, etc...)
//      Render Primary Planet Satellites in Sky

public class CelestialSkyRenderer extends IRenderHandler {

    // Sky Params
    private final CelestialBody body;
    private final Star star;
    private final ArrayList<CelestialBody> satellites = new ArrayList<>();
    private final Vec3 fogColor;

    // Utility
    private Tessellator tessellator;

    // Call Lists
    private final int glStarCallList;
    private int glListTopDome;
    private int glListBottomDome;

    public CelestialSkyRenderer(CelestialBody body, String fogColor) {

        this.body = body;
        this.star = body.getStar();
        this.satellites.addAll(body.getNameToSatelliteMap().values());

        this.fogColor = parseColor(fogColor);

        glStarCallList = GLAllocation.generateDisplayLists(3);

        setupGL();
        renderStars();
        genSkyDomeTop();
        genSkyDomeBottom();

    }

    // Called every tick
    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) {

        if(body.getParent() != null)
            renderPrimaryPlanet(body);

        if(!body.getNameToSatelliteMap().values().isEmpty())
            renderSatellites(body);

        if(!body.getParent().getNameToSatelliteMap().values().isEmpty())
            renderParentSatellites(body.getParent());

        renderSun(star);
        renderFog(fogColor);
        renderHorizon(mc, world, partialTicks);

    }

    // Renders bodies in the sky (ex: Earth, Mars & Phobos, etc...)
    private void renderPrimaryPlanet(CelestialBody body) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glCallList(glStarCallList);

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);

        GL11.glPushMatrix();
        GL11.glPopMatrix();
        GL11.glPushMatrix();

        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 5F);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);

        double size = 1;

        tessellator.startDrawingQuads();
        tessellator.addVertex(-size, 99.9D, -size);
        tessellator.addVertex(size, 99.9D, -size);
        tessellator.addVertex(size, 99.9D, size);
        tessellator.addVertex(-size, 99.9D, size);
        tessellator.draw();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        size = getPrimaryPlanetSizeFromDistance(body);

        GL11.glRotatef(75.0F, 1.0F, 0.0F, 0.0F);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(body.getParent().getIcon());

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-size, 100.0D, -size, 0.0D, 0.0D);
        tessellator.addVertexWithUV(size, 100.0D, -size, 1.0D, 0.0D);
        tessellator.addVertexWithUV(size, 100.0D, size, 1.0D, 1.0D);
        tessellator.addVertexWithUV(-size, 100.0D, size, 0.0D, 1.0D);
        tessellator.draw();

        GL11.glPopMatrix();
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_BLEND);

    }

    private void renderSatellites(CelestialBody body) {

        ;

    }

    private void renderParentSatellites(CelestialBody body) {

        ;

    }

    // Renders star in the sky based on distance away and size
    private void renderSun(Star star) {

        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1F);

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);

        GL11.glPushMatrix();
        GL11.glPopMatrix();
        GL11.glPushMatrix();

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 5F);
        GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);

        double size = getStarSizeFromDistance(body) / 3.5D;

        tessellator.startDrawingQuads();
        tessellator.addVertex(-size, 99.9D, -size);
        tessellator.addVertex(size, 99.9D, -size);
        tessellator.addVertex(size, 99.9D, size);
        tessellator.addVertex(-size, 99.9D, size);
        tessellator.draw();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        size = getStarSizeFromDistance(body);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(star.getStarIcon());

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-size, -100.0D, size, 0, 1);
        tessellator.addVertexWithUV(size, -100.0D, size, 1, 1);
        tessellator.addVertexWithUV(size, -100.0D, -size, 1, 0);
        tessellator.addVertexWithUV(-size, -100.0D, -size, 0, 0);
        tessellator.draw();

        GL11.glDisable(GL11.GL_BLEND);

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glPopMatrix();

    }

    // Renders horizon
    private void renderFog(Vec3 color) {

        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_FOG);

        GL11.glColor3f((int) color.xCoord, (int) color.yCoord, (int) color.zCoord);

        GL11.glCallList(glListTopDome);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        RenderHelper.disableStandardItemLighting();

    }

    private void renderHorizon(Minecraft mc, World world, float partialTicks) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);

        double playerHeightAboveHorizon = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();

        if (playerHeightAboveHorizon < 0.0D) {

            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(glListBottomDome);
            GL11.glPopMatrix();

            float unitSize = 1.0F;
            float translatedYPosition = -((float) (playerHeightAboveHorizon + 65.0D));
            float negativeUnitSize = -unitSize;

            tessellator.startDrawingQuads();
            
            tessellator.setColorRGBA_I(0, 255);
            
            tessellator.addVertex(-unitSize, translatedYPosition, unitSize);
            tessellator.addVertex(unitSize, translatedYPosition, unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, -unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, -unitSize);
            tessellator.addVertex(unitSize, translatedYPosition, -unitSize);
            tessellator.addVertex(-unitSize, translatedYPosition, -unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, -unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(unitSize, translatedYPosition, unitSize);
            tessellator.addVertex(unitSize, translatedYPosition, -unitSize);
            tessellator.addVertex(-unitSize, translatedYPosition, -unitSize);
            tessellator.addVertex(-unitSize, translatedYPosition, unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, -unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, -unitSize);
            tessellator.addVertex(-unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, unitSize);
            tessellator.addVertex(unitSize, negativeUnitSize, -unitSize);

            tessellator.draw();

        }

    }

    // Actually sets up star rendering and renders them
    private void renderStars() {

        GL11.glPushMatrix();
        GL11.glNewList(glStarCallList, GL11.GL_COMPILE);

        drawStars(SbndUtil.STAR_COUNT, SbndUtil.STAR_SEED);

        GL11.glEndList();
        GL11.glPopMatrix();

    }

    // Draws stars in the sky
    private void drawStars(int numStar, long seed) {

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

    // Generates Top Part of Sky Dome
    private void genSkyDomeTop() {

        glListTopDome = glStarCallList + 1;

        GL11.glNewList(glListTopDome, GL11.GL_COMPILE);

        byte cellSize = 64;
        int gridRange = 256 / cellSize + 2;
        float quadHeight = 16F;

        for (int i = -cellSize * gridRange; i <= cellSize * gridRange; i += cellSize) {

            for (int j = -cellSize * gridRange; j <= cellSize * gridRange; j += cellSize) {

                tessellator.startDrawingQuads();
                tessellator.addVertex(i, quadHeight, j);
                tessellator.addVertex(i + cellSize, quadHeight, j);
                tessellator.addVertex(i + cellSize, quadHeight, j + cellSize);
                tessellator.addVertex(i, quadHeight, j + cellSize);
                tessellator.draw();

            }

        }

        tessellator.draw();

        GL11.glEndList();

    }

    // Generates Bottom Part of Sky Dome
    private void genSkyDomeBottom() {

        glListBottomDome = glStarCallList + 2;

        GL11.glNewList(glListBottomDome, GL11.GL_COMPILE);

        byte cellSize = 64;
        int gridRange = 256 / cellSize + 2;
        float quadHeightNeg = -16F;

        for (int i = -cellSize * gridRange; i <= cellSize * gridRange; i += cellSize) {

            for (int j = -cellSize * gridRange; j <= cellSize * gridRange; j += cellSize) {

                tessellator.startDrawingQuads();
                tessellator.addVertex(i, quadHeightNeg, j);
                tessellator.addVertex(i + cellSize, quadHeightNeg, j);
                tessellator.addVertex(i + cellSize, quadHeightNeg, j + cellSize);
                tessellator.addVertex(i, quadHeightNeg, j + cellSize);
                tessellator.draw();

            }

        }

        tessellator.draw();

        GL11.glEndList();

    }

    //--------------------------EXTRAS--------------------------//

    // Setups GL Matrix Stack
    private void setupGL() {

        resetGL();

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor3f(1F, 1F, 1F);

        tessellator = Tessellator.instance;

    }

    // Resets GL Matrix Stack
    private void resetGL() {

        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glPopMatrix();

    }

    // Parses hex color into r, g, b
    private Vec3 parseColor(String color) {

        int colorInt = Integer.parseInt(color.substring(2), 16);

        int r = (colorInt >> 16) & 0xFF;
        int g = (colorInt >> 8) & 0xFF;
        int b = colorInt & 0xFF;

        return Vec3.createVectorHelper(r, g, b);

    }

    // Gets distance from satellite to primary planet
    private double getPrimaryPlanetSizeFromDistance(CelestialBody satellite) {

        double distance = satellite.getOrbitRadiusKm();
        double radius = satellite.getParent().getRadiusKm();

        return 2D * (float) Math.atan((2D * radius) / (2D * distance)) * SbndUtil.CELESTIAL_RENDER_MULTIPLIER;

    }

    // Gets distance from planet to star
    private double getStarSizeFromDistance(CelestialBody planet) {

        double distance = planet.getOrbitRadiusKm();
        double radius = planet.getStar().getRadiusKm();

        return 2D * (float) Math.atan((2D * radius) / (2D * distance)) * SbndUtil.CELESTIAL_RENDER_MULTIPLIER;

    }

}
