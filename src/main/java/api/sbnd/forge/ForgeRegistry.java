package api.sbnd.forge;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Allows easy block registry. You can probably just achieve this with a list, like I did before,
 * but a separate Registry class is more straightforward and sightreadable - also easier to
 * expand upon.
 *
 * @since 0.1.2
 * @author ItsAslanMods
 *
 * @param <T>
 */
public class ForgeRegistry<T> implements Iterable<T> {

    private final List<T> registry = new ArrayList<>();

    public T register(@NonNull T obj) {

        if(registry.contains(obj)) {
            throw new IllegalStateException(String.format("Object Trying to be Registered Twice!: %s | %s", obj, obj.getClass().getSimpleName()));
        }

        registry.add(obj);

        return obj;

    }

    @Override
    @NonNull
    public Iterator<T> iterator() {
        return registry.iterator();
    }

}
