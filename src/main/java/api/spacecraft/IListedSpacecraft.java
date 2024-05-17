package api.spacecraft;

import api.util.interfaces.IUnique;

public interface IListedSpacecraft extends IUnique {


    String getName();

    void setName(String name);

    default boolean canLaunch() {
        return false;
    }

    default void launch() {
        throw new UnsupportedOperationException();
    }

    boolean isDestroyed();

}
