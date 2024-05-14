package api.spacecraft;

import api.util.IFixedBoundWorldData;
import net.minecraft.world.World;

import java.util.List;

public interface ISpacecraftBodyData extends IFixedBoundWorldData {

    ISpacecraftController getController();

    List<ISpacecraftModule> getModules();

    ISpacecraftMetadata buildMetadata(World parent);

}
