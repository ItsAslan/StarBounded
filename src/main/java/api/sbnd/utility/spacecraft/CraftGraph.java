package api.sbnd.utility.spacecraft;

import api.sbnd.interfaces.ISpacecraft;
import api.sbnd.interfaces.ISpacecraftController;
import api.sbnd.interfaces.ISpacecraftModule;
import api.sbnd.utility.BlockPos;
import lombok.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.function.Predicate;

/**
 * The CraftGraph stores all spacecraft components as vertices to easily construct
 * the rocket entity and its calculations. The graph is generated via a BFS
 * (Breadth First Search) algorithm that sweeps through all rocket compatible blocks,
 * linking them to a central controller and storing them.
 *
 * @since 0.1.2
 * @author ItsAslanMods
 */
@RequiredArgsConstructor
@ParametersAreNonnullByDefault
@SuppressWarnings("RedundantIfStatement")
public class CraftGraph implements Iterable<ISpacecraftModule> {

    /* Will soon become variable with controller tier... maybe */
    public static final int RANGE = 32;

    @Value
    private static class Node {
        Vertex vertex;
        int distance;

        public static final int ROOT = 0;
    }

    @Value
    public static class NodeData {
        ISpacecraftModule module;
        BlockPos pos, from;
        EnumFacing dir;
    }

    @FunctionalInterface
    public interface SearchFilter extends Predicate<NodeData> {

        SearchFilter BYPASS = n -> true;

        boolean test(NodeData nodeData);

    }

    @Getter
    private final ISpacecraft spacecraft;

    private final Map<Vertex, List<Vertex>> adjacents = new HashMap<>();

    private List<Vertex> getAdjacent(Vertex vertex) {
        return adjacents.computeIfAbsent(vertex, v -> new ArrayList<>());
    }

    public void scan(World world, BlockPos root) {
        scan(world, root, SearchFilter.BYPASS);
    }

    public void scan(World world, BlockPos root, SearchFilter extraFilter) {

        SearchFilter filter = data -> {

            if(!extraFilter.test(data)) {
                return false;
            }
            if(data.getModule() instanceof ISpacecraftController) {
                return false;
            }

            ISpacecraft owner = data.getModule().getOwner();

            if(owner == null || owner.equals(getSpacecraft())) {
                return true;
            }

            return false;

        };

        adjacents.keySet().forEach(v -> {

            ISpacecraftModule module = v.getModule();

            if(module != null) {
                module.setOwner(null);
            }

        });

        adjacents.clear();

        Set<BlockPos> seen = new HashSet<>();
        seen.add(root);

        ISpacecraftController controller = (ISpacecraftController) world.getTileEntity(root.getX(), root.getY(), root.getZ());
        Queue<Node> search = new ArrayDeque<>();

        Vertex rootVertex = new Vertex(controller, root);
        search.add(new Node(rootVertex, Node.ROOT));
        getAdjacent(rootVertex);

        while(!search.isEmpty()) {

            Node node = search.poll();
            if(node.getDistance() < RANGE) {

                for(EnumFacing face : EnumFacing.values()) {

                    BlockPos pos = node.getVertex().getPos().offset(face);
                    TileEntity te = world.getTileEntity(pos.getX(), pos.getY(), pos.getZ());

                    if( te == null ) { continue; }

                    if(te instanceof ISpacecraftModule) {

                        Vertex newVertex = new Vertex((ISpacecraftModule) te, pos);
                        if(filter.test(new NodeData(newVertex.getModule(), newVertex.getPos(), node.getVertex().getPos(), face))) {

                            if(!seen.contains(pos)) {

                                search.offer(new Node(newVertex, node.getDistance() + 1));
                                ((ISpacecraftModule) te).setOwner(getSpacecraft());

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

    @Override
    @NonNull
    public Iterator<ISpacecraftModule> iterator() {
        return adjacents.keySet().stream().map(v -> v.getModule()).iterator();
    }

    public boolean isEmpty() {
        return adjacents.isEmpty();
    }

    /* Vertex for the BFS Search */
    @Getter
    @AllArgsConstructor
    private static class Vertex {

        private ISpacecraftModule module;
        private BlockPos pos;

        @Override
        public boolean equals(@NonNull Object obj) {

            if(obj == this) { return true; }
            if(obj.getClass() != this.getClass()) { return false; }

            Vertex other = (Vertex) obj;

            if(!module.getId().equals(other.module.getId())) { return false; }

            return pos.equals(other.pos);

        }

    }

}
