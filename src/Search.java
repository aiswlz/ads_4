import java.util.*;

/**
 * Abstract class representing a search in a graph.
 *
 * @param <Vertex> The type of vertices in the graph.
 */
public abstract class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;


    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

     //Checks if there is a path to the specified vertex.
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    /**
     * Returns an iterable of vertices representing the path to the specified vertex.
     *
     * @param v The destination vertex.
     * @return An iterable of vertices in the path, or null if no path exists.
     */
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = v; x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
