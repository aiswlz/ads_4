import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// Represents a weighted graph with vertices and edges.
public class WeightedGraph<Vertex> {
    private boolean undirected;
    private Map<Vertex,Map<Vertex,Double>> vertices = new HashMap<>();
    public WeightedGraph() {
        this(true);
    }

    /**
     * Constructs a weighted graph with the specified directionality.
     *
     * @param undirected True for an undirected graph, false for a directed graph.
     */
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    //Adds a vertex to the graph.
    public void addVertex(Vertex v) {
        vertices.put(v, new HashMap<>());
    }


    /**
     * Adds an edge between two vertices with the specified weight.
     *
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(Vertex source, Vertex destination, double weight) {
        if (!vertices.containsKey(source))
            addVertex(source);

        if (!vertices.containsKey(destination))
            addVertex(destination);

        if (hasEdge(source, destination) || source.equals(destination))
            return;

        vertices.get(source).put(destination,weight);
        vertices.get(destination).put(source,weight);
    }


    // Checks if there is an edge between two vertices.
    private boolean hasEdge(Vertex source, Vertex destination) {
        if (!vertices.containsKey(source)) return false;
        return vertices.get(source).containsKey(destination);
    }


    /**
     * Returns the neighbors of the specified vertex.
     *
     * @param v The vertex whose neighbors are to be returned.
     * @return A set of neighboring vertices.
     */
    public Set<Vertex> getNeighbours(Vertex v) {
        if (!vertices.containsKey(v))
            throw new IndexOutOfBoundsException("Vertex doesn't exist");
        return vertices.get(v).keySet();
    }

    //Returns the weight of the edge between two vertices.
    public double getEdgeWeight(Vertex source, Vertex dest) {
        if (!hasEdge(source, dest))
            throw new IllegalArgumentException("Edge does not exist");
        return vertices.get(source).get(dest);
    }

    public void printGraph() {
        for (Vertex vertex: vertices.keySet()) {
            System.out.printf("Vertex %s connected to %s\n", vertex, vertices.get(vertex));
        }
    }

    private void checkVertex(Vertex vertex) {
        if(!vertices.containsKey(vertex)) throw new IndexOutOfBoundsException("Vertex does not exist");
    }

    public void removeEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);

        vertices.get(source).remove(dest);
        vertices.get(dest).remove(source);
    }

    public void removeVertex(Vertex vertex) {
        checkVertex(vertex);

        for (Vertex local : vertices.keySet()) {
            vertices.get(local).remove(vertex);
        }
        vertices.remove(vertex);
    }
}