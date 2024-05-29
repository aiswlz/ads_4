import java.util.HashMap;
import java.util.Map;

//Represents a vertex in a graph with data and adjacent vertices.
public class Vertex<V> {
    private V data; //<V> The type of data stored in the vertex.
    private Map<Vertex<V>, Double> adjacentVertices;


    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }


    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public V getData() {
        return data;
    }


    // Returns a map of adjacent vertices with their respective edge weights
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    // Checks if there is an edge to the specified destination vertex.
    public boolean hasAdjacentVertices(Vertex<V> destination) {
        return adjacentVertices.containsKey(destination);
    }

    // Returns the weight of the edge to the specified destination vertex.
    public double getWeightTo(Vertex<V> destination) {
        return adjacentVertices.get(destination);
    }
}
