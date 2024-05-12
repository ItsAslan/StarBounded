package com.sbnd.entity.spacecraft;

import api.interfaces.annotations.ToDo;
import api.spacecraft.ISpacecraft;
import api.spacecraft.ISpacecraftController;
import api.spacecraft.ISpacecraftModule;
import api.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SpacecraftBlueprint implements Iterable<ISpacecraftModule> {

    public static class Vertex {

        private ISpacecraftModule module;
        private BlockPos pos;

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }
            else if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Vertex other = (Vertex) obj;

            if(!module.getId().equals(other.module.getId())) {
                return false;
            }

            return pos.equals(other.pos);

        }

    }

    private static class SearchNode {
        private Vertex vertex;
        private int distance;
    }

    public static class SearchData {
        private ISpacecraftModule module;
        private BlockPos pos, from;
        private EnumFacing dir;
    }

    public interface SearchFilter extends Predicate<SearchData> {
        SearchFilter TRUE = d -> true;
        boolean test(SearchData data);
    }

    public static final int RANGE = 32;

    private ISpacecraft spacecraft;

    private final Map<Vertex, List<Vertex>> adjacencies = new HashMap<>();

    private List<Vertex> getAdjacent(Vertex vertex) {
        return adjacencies.computeIfAbsent(vertex, v -> new ArrayList<>());
    }

    public void scan(BlockPos root, World world) {
        scan(root, world, SearchFilter.TRUE);
    }

    @ToDo("aubh")
    public void scan(BlockPos root, World world, SearchFilter extraFilter) {

        SearchFilter filter = data -> {
            if(!extraFilter.test(data)) {
                return false;
            }
            if (data.module instanceof ISpacecraftController) {
                return false;
            }
            ISpacecraft owner = data.module.getOwner();
            if(owner == null || owner.equals(spacecraft)) {
                return false;
            }
            return false;
        };

    }

    @Override
    public Iterator<ISpacecraftModule> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super ISpacecraftModule> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<ISpacecraftModule> spliterator() {
        return Iterable.super.spliterator();
    }


}
