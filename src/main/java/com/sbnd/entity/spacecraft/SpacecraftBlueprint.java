package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraft;
import api.spacecraft.ISpacecraftModule;
import api.util.BlockPos;
import com.sbnd.lib.Library;

import net.minecraft.util.EnumFacing;

import java.util.*;
import java.util.function.Predicate;

public class SpacecraftBlueprint {


    private static class Vertex {
        private ISpacecraftModule module;
        private BlockPos pos;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Vertex other = (Vertex) obj;

            if (!module.getId().equals(other.module.getId())) {
                return false;
            }

            return pos.equals(other.pos);
        }

        public ISpacecraftModule getModule() {
            return module;
        }

        public BlockPos getPos() {
            return pos;
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

    public static final int RANGE = Library.getRocketRange();

    private ISpacecraft spacecraft;

    private final Map<Vertex, List<Vertex>> adjacencies = new HashMap<>();

    private List<Vertex> getAdjacent(Vertex vertex) {
        return adjacencies.computeIfAbsent(vertex, v -> new ArrayList<>());
    }

    // Add Scanning Logic

    public Iterable<BlockPos> getPositions() {
        return adjacencies.keySet().stream().map(Vertex::getPos)::iterator;
    }

    public Iterator<ISpacecraftModule> iterator() {
        return adjacencies.keySet().stream().map(Vertex::getModule).distinct().iterator();
    }

    public boolean isEmpty() {
        return adjacencies.isEmpty();
    }

}
