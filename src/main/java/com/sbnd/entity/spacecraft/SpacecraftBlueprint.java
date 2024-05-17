package com.sbnd.entity.spacecraft;

import api.spacecraft.ISpacecraft;
import api.spacecraft.ISpacecraftController;
import api.spacecraft.ISpacecraftModule;
import api.util.BlockPos;
import com.sbnd.lib.Library;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.*;
import java.util.function.Predicate;

public class SpacecraftBlueprint implements Iterable<ISpacecraftModule> {


    private static class Vertex {
        private final ISpacecraftModule module;
        private final BlockPos pos;

        public Vertex(ISpacecraftModule module, BlockPos pos) {
            this.module = module;
            this.pos = pos;
        }

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
        private final Vertex vertex;
        private final int distance;

        public SearchNode(Vertex vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

    }

    public static class SearchData {
        private ISpacecraftModule module;
        private BlockPos pos, from;
        private EnumFacing dir;

        public SearchData(ISpacecraftModule module, BlockPos pos, BlockPos from, EnumFacing dir) {
            this.module = module;
            this.pos = pos;
            this.from = from;
            this.dir = dir;
        }
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
    public void scan(BlockPos root, World world, SearchFilter extraFilter) {

        SearchFilter filter = data -> {
            if (!extraFilter.test(data)) {
                return false;
            }
            if (data.module instanceof ISpacecraftController) {
                return false;
            }

            ISpacecraft owner = data.module.getOwner();

            if (owner == null || owner.isInvalid() || owner.equals(spacecraft)) {

                return true;
            }
            return false;
        };

        // Clear owners
        adjacencies.values().stream().flatMap(List::stream).forEach(v -> {
            ISpacecraftModule module = v.getModule();
            if (module != null) {
                module.setOwner(null);
            }
        });

        // Empty graph
        adjacencies.clear();

        // Set up BFS
        Set<BlockPos> seen = new HashSet<>();
        seen.add(root);

        ISpacecraftModule module = (ISpacecraftModule) world.getTileEntity((int) root.x, (int) root.y, (int) root.z);
        Queue<SearchNode> search = new ArrayDeque<>();

        Vertex rootVertex = new Vertex(module, root);
        search.add(new SearchNode(rootVertex, 0));
        getAdjacent(rootVertex); // Add empty mapping for root so it's in the keyset

        // Find all modules
        while (!search.isEmpty()) {
            SearchNode node = search.poll();
            if (node.distance < RANGE) {
                for (EnumFacing face : EnumFacing.values()) {
                    BlockPos pos = node.vertex.getPos().offset(face);
                    TileEntity tileEntity = world.getTileEntity((int) pos.x, (int) pos.y, (int) pos.z);
                    Vertex newVertex = new Vertex(module, pos);
                    if (filter.test(new SearchData(newVertex.getModule(), newVertex.getPos(), node.vertex.getPos(), face))) {
                        // Only search through this node if it's not been seen before
                        if (!seen.contains(pos)) {
                            search.offer(new SearchNode(newVertex, node.distance + 1));
                            module.setOwner(spacecraft);
                        }
                        getAdjacent(node.vertex).add(newVertex);
                        getAdjacent(newVertex).add(node.vertex);
                        seen.add(pos);
                    }
                }
            }
        }

    }

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
