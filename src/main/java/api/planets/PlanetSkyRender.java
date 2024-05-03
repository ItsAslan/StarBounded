package api.planets;

import api.enums.EnumPlanet;
import api.enums.EnumStar;
import com.sbnd.world.PlanetManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Random;

@SideOnly(Side.CLIENT)
public abstract class PlanetSkyRender extends IRenderHandler
{

    public int starGLCallList = GLAllocation.generateDisplayLists(3);
    public int glSkyList;
    public int glSkyList2;

    public int numStars = 9000;

    public PlanetSkyRender()
    {

        GL11.glPushMatrix();
        GL11.glNewList(this.starGLCallList, GL11.GL_COMPILE);

        if(canSeeStars()) { this.renderStars(); }

        GL11.glEndList();
        GL11.glPopMatrix();
        final Tessellator tessellator = Tessellator.instance;
        this.glSkyList = this.starGLCallList + 1;
        GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
        final byte byte2 = 64;
        final int i = 256 / byte2 + 2;
        float f = 16F;

        for (int j = -byte2 * i; j <= byte2 * i; j += byte2)
        {
            for (int l = -byte2 * i; l <= byte2 * i; l += byte2)
            {
                tessellator.startDrawingQuads();
                tessellator.addVertex(j + 0, f, l + 0);
                tessellator.addVertex(j + byte2, f, l + 0);
                tessellator.addVertex(j + byte2, f, l + byte2);
                tessellator.addVertex(j + 0, f, l + byte2);
                tessellator.draw();
            }
        }

        GL11.glEndList();
        this.glSkyList2 = this.starGLCallList + 2;
        GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
        f = -16F;
        tessellator.startDrawingQuads();

        for (int k = -byte2 * i; k <= byte2 * i; k += byte2)
        {
            for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
            {
                tessellator.addVertex(k + byte2, f, i1 + 0);
                tessellator.addVertex(k + 0, f, i1 + 0);
                tessellator.addVertex(k + 0, f, i1 + byte2);
                tessellator.addVertex(k + byte2, f, i1 + byte2);
            }
        }

        tessellator.draw();
        GL11.glEndList();
    }

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc)
    {

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor3f(1F, 1F, 1F);
        final Tessellator var23 = Tessellator.instance;
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_FOG);
        float[] color = PlanetManager.getSkyColor(getCurrentPlanet());
        GL11.glColor3f(color[0], color[1], color[2]);
        GL11.glCallList(this.glSkyList);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        RenderHelper.disableStandardItemLighting();
        float var10 = 0;
        float var11 = 0;
        float var12 = 0;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); // Set full visibility
        GL11.glCallList(this.starGLCallList);

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
        var12 = PlanetManager.getPrimaryPlanetSize(getCurrentPlanet());

        if(isOrbitingBody()) { drawPrimaryPlanet(var23, var12); }

        // HOME:
        var12 = PlanetManager.getStarSize(getCurrentPlanet());
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        float rot = PlanetManager.getStarRotation(getCurrentPlanet());
        GL11.glRotatef(rot, 1.0F, 0.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1F);

        drawStar(var23, var12);

        final double var25 = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();
        renderHorizon(mc, var10, var11, var12, var25, var23, partialTicks, world);

        GL11.glColor3f(70F / 256F, 70F / 256F, 70F / 256F);

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -((float) (var25 - 16.0D)), 0.0F);
        GL11.glCallList(this.glSkyList2);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glDisable(GL11.GL_FOG);
    }

    private void drawPrimaryPlanet(Tessellator var23, float var12)
    {

        var23.startDrawingQuads();
        var23.addVertex(-var12, 99.9D, -var12);
        var23.addVertex(var12, 99.9D, -var12);
        var23.addVertex(var12, 99.9D, var12);
        var23.addVertex(-var12, 99.9D, var12);
        var23.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var12 = 20.0F;

        // Here is where you change the angle of the earth
        GL11.glRotatef(75.0F, 1.0F, 0.0F, 0.0F);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(getPrimaryPlanet().getTexture());
        var23.startDrawingQuads();
        var23.addVertexWithUV(-var12, 100.0D, -var12, 0.0D, 0.0D);
        var23.addVertexWithUV(var12, 100.0D, -var12, 1.0D, 0.0D);
        var23.addVertexWithUV(var12, 100.0D, var12, 1.0D, 1.0D);
        var23.addVertexWithUV(-var12, 100.0D, var12, 0.0D, 1.0D);
        var23.draw();
        GL11.glPopMatrix();
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_BLEND);
    }

    private void drawStar(Tessellator var23, float var12)
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(getPlanetStar().getTexture());
        var23.startDrawingQuads();
        var23.addVertexWithUV(-var12, -100.0D, var12, 0, 1);
        var23.addVertexWithUV(var12, -100.0D, var12, 1, 1);
        var23.addVertexWithUV(var12, -100.0D, -var12, 1, 0);
        var23.addVertexWithUV(-var12, -100.0D, -var12, 0, 0);
        var23.draw();
        GL11.glDisable(GL11.GL_BLEND);
    }

    private void renderHorizon(Minecraft mc, float var10, float var11, float var12, double var25, Tessellator var23, float partialTicks, World world)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);

        if (var25 < 0.0D)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(this.glSkyList2);
            GL11.glPopMatrix();
            var10 = 1.0F;
            var11 = -((float) (var25 + 65.0D));
            var12 = -var10;
            var23.startDrawingQuads();
            var23.setColorRGBA_I(0, 255);
            var23.addVertex(-var10, var11, var10);
            var23.addVertex(var10, var11, var10);
            var23.addVertex(var10, var12, var10);
            var23.addVertex(-var10, var12, var10);
            var23.addVertex(-var10, var12, -var10);
            var23.addVertex(var10, var12, -var10);
            var23.addVertex(var10, var11, -var10);
            var23.addVertex(-var10, var11, -var10);
            var23.addVertex(var10, var12, -var10);
            var23.addVertex(var10, var12, var10);
            var23.addVertex(var10, var11, var10);
            var23.addVertex(var10, var11, -var10);
            var23.addVertex(-var10, var11, -var10);
            var23.addVertex(-var10, var11, var10);
            var23.addVertex(-var10, var12, var10);
            var23.addVertex(-var10, var12, -var10);
            var23.addVertex(-var10, var12, -var10);
            var23.addVertex(-var10, var12, var10);
            var23.addVertex(var10, var12, var10);
            var23.addVertex(var10, var12, -var10);
            var23.draw();
        }
    }

    private void renderStars()
    {
        final Random var1 = new Random(10842L);

        GL11.glEnable(GL11.GL_POINT_SMOOTH); // Enable smooth points
        GL11.glPointSize(2.0F); // Set the point size for visible stars
        GL11.glBegin(GL11.GL_POINTS); // Start drawing points
        GL11.glColor3f(1.0F, 1.0F, 1.0F);

        for (int i = 0; i < this.numStars; ++i) {
            double x = var1.nextFloat() * 2.0F - 1.0F;
            double y = var1.nextFloat() * 2.0F - 1.0F;
            double z = var1.nextFloat() * 2.0F - 1.0F;
            double distance = Math.sqrt(x * x + y * y + z * z);

            if (distance < 1.0D && distance > 0.01D) { // Ensure stars are within unit sphere
                x /= distance;
                y /= distance;
                z /= distance;
                double scale = 100.0 + var1.nextDouble() * 50.0; // Scale them between 100 and 150 units away

                GL11.glVertex3d(x * scale, y * scale, z * scale);
            }
        }

        GL11.glEnd(); // Finish drawing points
        GL11.glDisable(GL11.GL_POINT_SMOOTH); // Disable smooth points if not needed elsewhere
    }

    protected abstract boolean canSeeStars();
    protected abstract boolean isOrbitingBody();
    protected abstract boolean hasMoons();

    protected abstract EnumPlanet getPrimaryPlanet();
    protected abstract EnumPlanet getCurrentPlanet();
    protected abstract EnumStar getPlanetStar();
    protected abstract EnumPlanet[] getMoons();
}