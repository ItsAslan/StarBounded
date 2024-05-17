package api.spacecraft;

import api.interfaces.annotations.ToDo;
import net.minecraft.world.World;

import java.util.Collection;

public interface ISpacecraft extends IListedSpacecraft {

    String getName();

    ISpacecraftController getController();

    Collection<ISpacecraftModule> getModules();

    boolean isInvalid();

    ISpacecraftBodyData buildBodyData(World world);

    IListedSpacecraft toListedCraft();

    World getWorld();

    @ToDo("Ticking stuff")
    default void tick(long elapsedTicks) {

        // Ticking Stuff

    }

}
