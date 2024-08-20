package com.sbnd.world.tmp.core.gen;

import com.sbnd.main.ResourceManager;
import com.sbnd.main.SbndUtil;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Random;

import static com.sbnd.world.tmp.core.EnumCelestialType.*;

// This is a custom class for rendering the sky for any given `CelestialBody`

// The state the renderer is in right now is very primitive and is subject to substantial change.
// Currently, the renderer renders:
//      Single Star
//      Single Parent Planet
//      Stars In Sky
//      Automatic Primary Planet Rendering
//      Automatic Star Rendering
//      Automatic Size Calculations Based on Distance From Body

// The renderer won't work in this state, for sizes are arbitrary numbers, icon loading
// is not implemented, and the code is overall not optimized.

// The renderer will support (basically a to-do list for the next few commits):
//      Celestial Angle
//      Cool Graphics (Glare, Bloom, Glow, etc...)
//      Render Primary Planet Satellites in Sky

@SideOnly(Side.CLIENT)
public class SkyRendererCelestial extends IRenderHandler {

    CelestialBody body;

    private final String fogColor = "0x171717";

    private int glStarList;
    private int glTopDomeList;
    private int glBottomDomeList;

    private Tessellator tessellator;

    public SkyRendererCelestial(CelestialBody body) {

        this.body = body;

        tessellator = Tessellator.instance;

        initializeDisplayLists();

    }

    private void initializeDisplayLists() {

        glStarList = GLAllocation.generateDisplayLists(3);

        GL11.glPushMatrix();
        GL11.glNewList(glStarList, GL11.GL_COMPILE);

        renderStars();

        GL11.glEndList();
        GL11.glPopMatrix();

        glTopDomeList = createSkyList(16);
        glBottomDomeList = createSkyList(-16);

    }

    private int createSkyList(float yOffset) {

        int skyList = GLAllocation.generateDisplayLists(1);

        GL11.glNewList(skyList, GL11.GL_COMPILE);

        createSky(yOffset);

        GL11.glEndList();

        return skyList;

    }

    private void createSky(float yOffset) {

        final byte size = 64;
        final int count = 256 / size + 2;

        for (int i = -size * count; i <= size * count; i += size) {

            for (int j = -size * count; j <= size * count; j += size) {

                tessellator.startDrawingQuads();
                tessellator.addVertex(i, yOffset, j);
                tessellator.addVertex(i + size, yOffset, j);
                tessellator.addVertex(i + size, yOffset, j + size);
                tessellator.addVertex(i, yOffset, j + size);
                tessellator.draw();

            }

        }

    }

    private void renderStars() {

        Random rand = new Random(SbndUtil.STAR_SEED);

        GL11.glEnable(GL11.GL_POINT_SMOOTH);
        GL11.glPointSize(2.0F);
        GL11.glBegin(GL11.GL_POINTS);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);

        for (int i = 0; i < SbndUtil.STAR_COUNT; ++i) {

            double x = rand.nextFloat() * 2.0F - 1.0F;
            double y = rand.nextFloat() * 2.0F - 1.0F;
            double z = rand.nextFloat() * 2.0F - 1.0F;
            double distance = Math.sqrt(x * x + y * y + z * z);

            if (distance < 1.0D && distance > 0.01D) {

                x /= distance;
                y /= distance;
                z /= distance;
                double scale = 100.0 + rand.nextDouble() * 50.0;

                GL11.glVertex3d(x * scale, y * scale, z * scale);

            }

        }

        GL11.glEnd();
        GL11.glDisable(GL11.GL_POINT_SMOOTH);

    }

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) {

        setupRenderEnvironment();
        renderSkyColor();

        GL11.glCallList(glTopDomeList);

        disableRenderEffects();

        GL11.glCallList(glStarList);

        renderCelestialBodies(partialTicks, world, mc);

        resetRenderEnvironment();

    }

    private void setupRenderEnvironment() {

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor3f(1F, 1F, 1F);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_FOG);

    }

    private void renderSkyColor() {

        int colorInt = Integer.parseInt(fogColor.substring(2), 16);

        float red = ((colorInt >> 16) & 0xFF) / 255.0f;
        float green = ((colorInt >> 8) & 0xFF) / 255.0f;
        float blue = (colorInt & 0xFF) / 255.0f;

        GL11.glColor3f(red, green, blue);

    }

    private void disableRenderEffects() {

        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        RenderHelper.disableStandardItemLighting();

    }

    private void renderCelestialBodies(float partialTicks, WorldClient world, Minecraft mc) {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glPushMatrix();

        if(body.getType() == SATELLITE)
            renderPrimaryPlanet();

        renderStar(world, partialTicks);

        renderHorizon(mc, world, partialTicks);

        GL11.glPopMatrix();

    }

    private void renderPrimaryPlanet() {

        GL11.glPushMatrix();
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(false);

        drawPrimaryPlanet(getPrimaryPlanetSizeFromDistance(body));

        GL11.glDepthMask(true);
        GL11.glPopMatrix();

    }

    private void drawPrimaryPlanet(float size) {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        GL11.glRotatef(75.0F, 1.0F, 0.0F, 0.0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(body.getParent().getIcon());

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-size, 100.0D, -size, 0.0D, 0.0D);
        tessellator.addVertexWithUV(size, 100.0D, -size, 1.0D, 0.0D);
        tessellator.addVertexWithUV(size, 100.0D, size, 1.0D, 1.0D);
        tessellator.addVertexWithUV(-size, 100.0D, size, 0.0D, 1.0D);
        tessellator.draw();

    }

    private void renderStar(WorldClient world, float partialTicks) {

        GL11.glPushMatrix();
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glRotatef(getCelestialAngle(body, world, partialTicks) * 360, 1.0F, 0.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDepthMask(false);

        drawStar(getStarSizeFromDistance(body));

        GL11.glDepthMask(true);
        GL11.glPopMatrix();

    }

    private void drawStar(float size) {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(body.getStar().getIcon());

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-size, -100.0D, size, 0, 1);
        tessellator.addVertexWithUV(size, -100.0D, size, 1, 1);
        tessellator.addVertexWithUV(size, -100.0D, -size, 1, 0);
        tessellator.addVertexWithUV(-size, -100.0D, -size, 0, 0);
        tessellator.draw();

        GL11.glDisable(GL11.GL_BLEND);

    }

    private void renderHorizon(Minecraft mc, WorldClient world, float partialTicks) {

        double playerHeightAboveHorizon  = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();

        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);

        if (playerHeightAboveHorizon  < 0.0D) {

            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(glBottomDomeList);
            GL11.glPopMatrix();
            float unitSize = 1.0F;
            float translatedYPosition = -((float) (playerHeightAboveHorizon  + 65.0D));
            float negativeUnitSize = -translatedYPosition;
            drawHorizon(tessellator, unitSize, translatedYPosition, negativeUnitSize);

        }

    }

    private void drawHorizon(Tessellator tessellator, float unitSize, float translatedYPosition, float negativeUnitSize) {

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

    private void resetRenderEnvironment() {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glDisable(GL11.GL_FOG);

    }

    // Gets distance from satellite to primary planet
    private float getPrimaryPlanetSizeFromDistance(CelestialBody satellite) {

        double distance = satellite.getOrbitRadiusKm();
        double radius = satellite.getParent().getRadiusKm();

        return (float) (2D * Math.atan(radius / distance) * SbndUtil.CELESTIAL_RENDER_MULTIPLIER);


    }

    // Gets distance from planet to star
    private float getStarSizeFromDistance(CelestialBody body) {

        return body.getType() == SATELLITE ? getStarSizeFromSatellite(body) : getStarSizeNormal(body);

    }

    // This makes sense right?
    private float getStarSizeFromSatellite(CelestialBody satellite) {

        double parentDistance = satellite.getParent().getOrbitRadiusKm();
        double radius = satellite.getParent().getStar().getRadiusKm();

        double distanceFromParent = satellite.getOrbitRadiusKm();

        double distance = parentDistance + distanceFromParent;

        return (float) (2D * Math.atan(radius / distance) * SbndUtil.SUN_RENDER_MULTIPLIER);

    }

    private float getStarSizeNormal(CelestialBody planet) {

        double distance = planet.getOrbitRadiusKm();
        double radius = planet.getStar().getRadiusKm();

        return (float) (2D * Math.atan(radius / distance) * SbndUtil.SUN_RENDER_MULTIPLIER);

    }

    private float getCelestialAngle(CelestialBody body, WorldClient world, float partialTicks) {

        return body.isTidallyLocked() ? getTidallyLockedAngle(body, world, partialTicks) : getNormalAngle(body, world, partialTicks);

    }

    private float getNormalAngle(CelestialBody body, WorldClient world, float partialTicks) {

        float dayLength = ((body.getDayLengthSeconds() / SbndUtil.SECONDS_MC_DAY) * SbndUtil.GAME_TICK);

        float celestialAngle = ((world.getWorldTime() + partialTicks) % dayLength) / dayLength;

        celestialAngle = celestialAngle > 0.5F ? (1.0F - celestialAngle) : celestialAngle;

        celestialAngle = 1.0F - (float)((Math.cos(celestialAngle * Math.PI) + 1.0D) / 2.0D);

        return celestialAngle * (float)Math.cos(Math.toRadians(body.getAxialTiltDegrees())) * 360F;

    }

    private float getTidallyLockedAngle(CelestialBody body, WorldClient world, float partialTicks) {

        float orbitalPeriod = (float) (body.getOrbitalPeriodSeconds() * SbndUtil.GAME_TICK);

        float celestialAngle = (world.getWorldTime() + partialTicks) % orbitalPeriod / orbitalPeriod;

        celestialAngle = (celestialAngle * 360.0F) + getNormalAngle(body.getParent(), world, partialTicks);

        celestialAngle = celestialAngle % 360.0F;

        return celestialAngle * (float)Math.cos(Math.toRadians(body.getAxialTiltDegrees()));

    }

}
