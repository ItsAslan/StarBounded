package api.interfaces.spacecrafts;

import net.minecraft.world.World;

import java.util.List;

public interface ISpacecraftStructureData
{

    ISpacecraftController getController();

    List<ISpacecraftModule> getModules();

    ISpacecraftMetadata buildSpacecraftMetaData(World world);

}
