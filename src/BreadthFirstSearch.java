import java.util.LinkedList;
import java.util.Queue;


// Class for performing breadth-first search (BFS) on a weighted graph.
public class BreadthFirstSearch<Vertex> extends Search<Vertex>{
    public BreadthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(WeightedGraph<Vertex> graph, Vertex current) {
        marked.add(current);// Mark the source vertex as visited.


        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);// Start BFS from the source vertex.

        while (!queue.isEmpty()) {
            Vertex v = queue.remove(); // Get the next vertex to explore from the queue.

            // Explore all neighbors of the current vertex.
            for (Vertex vertex : graph.getNeighbours(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);// Record the path to the neighbor.
                    queue.add(vertex);// Add neighbor to the queue for further exploration.
                }
            }
        }
    }
}