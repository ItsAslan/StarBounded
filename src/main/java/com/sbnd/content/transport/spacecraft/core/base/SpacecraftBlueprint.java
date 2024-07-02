package com.sbnd.content.transport.spacecraft.core.base;

import api.backport.BlockPos;
import com.sbnd.content.transport.spacecraft.core.craft.ISpacecraft;
import com.sbnd.content.transport.spacecraft.core.craft.ISpacecraftController;
import com.sbnd.content.transport.spacecraft.core.craft.ISpacecraftModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.*;
import java.util.function.Predicate;

public class SpacecraftBlueprint {

    public static final int SEARCH_RANGE = 32;

    @Getter
    @AllArgsConstructor
    private static class Vertex {

        private final ISpacecraftModule module;
        private final BlockPos pos;

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Vertex other = (Vertex) obj;

            return pos.equals(other.pos);

        }

    }

    @Getter
    @AllArgsConstructor
    public static class Node {

        private final Vertex vertex;
        private final int distance;

    }

    @Getter
    @AllArgsConstructor
    public static class Data {

        private ISpacecraftModule module;
        private BlockPos pos, from;
        private EnumFacing dir;

    }

    public interface SearchFilter extends Predicate<Data> {

        SearchFilter TRUE = d -> true;

        boolean test(Data data);

    }

    private ISpacecraft spacecraft;

    private final Map<Vertex, List<Vertex>> adjacencies = new HashMap<>();

    private List<Vertex> getAdjacent(Vertex vertex) {
        return adjacencies.computeIfAbsent(vertex, v -> new ArrayList<>());
    }

    public void scan(BlockPos root, World world, SearchFilter extraFilter) {

        SearchFilter filter = data -> {

            if (!extraFilter.test(data)) {
                return false;
            }
            if (data.module instanceof ISpacecraftController) {
                return false;
            }

            ISpacecraft owner = data.module.getOwner();

            return owner == null || owner.equals(spacecraft);

        };

        adjacencies.values().stream().flatMap(List::stream).forEach(v -> {

            ISpacecraftModule module = v.getModule();

            if(module.getOwner() != null) {

                module.setOwner(null);

            }

        });

        adjacencies.clear();

        Set<BlockPos> seen = new HashSet<>();
        seen.add(root);

        ISpacecraftModule module = (ISpacecraftModule) world.getTileEntity(root.getX(), root.getY(), root.getZ());
        Queue<Node> search = new ArrayDeque<>();

        Vertex rootVertex = new Vertex(module, root);
        search.add(new Node(rootVertex, 0));
        getAdjacent(rootVertex);

        while(search.isEmpty()) {

            Node node = search.poll();

            if(node.getDistance() < SEARCH_RANGE) {

                for(EnumFacing face : EnumFacing.values()) {

                    BlockPos pos = node.getVertex().getPos().offset(face);
                    TileEntity te = world.getTileEntity(pos.getX(), pos.getY(), pos.getZ());

                    Vertex newVertex = new Vertex(module, pos);

                    if(filter.test(new Data(newVertex.getModule(), newVertex.getPos(), node.getVertex().getPos(), face))) {

                        if (!seen.contains(pos)) {

                            search.offer(new Node(newVertex, node.getDistance() + 1));

                            module.setOwner(spacecraft);

                        }

                        getAdjacent(node.getVertex()).add(newVertex);
                        getAdjacent(newVertex).add(node.getVertex());
                        seen.add(pos);

                    }

                }

            }

        }

    }

}
