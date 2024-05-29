
public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeight(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Astana");
        outputPath(djk, "Shymkent");

        System.out.println("--------------------------------");

        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillWithWeight(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DijkstraSearch<>(graph, "Astana");
        outputPath(dfs, "Shymkent");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Astana");
        outputPath(bfs, "Shymkent");
    }

    public static void fillWithWeight(WeightedGraph<String> graph) {
        graph.addEdge("Astana", "Almaty", 2.1);
        graph.addEdge("Semey", "Oskemen", 7.8);
        graph.addEdge("Oskemen", "Almaty", 7.1);
        graph.addEdge("Astana", "Semey", 7.2);
        graph.addEdge("Semey", "Almaty", 3.9);
        graph.addEdge("Almaty", "Ayakoz", 3.5);
        graph.addEdge("Semey", "Shymkent", 5.4);
    }

    /**
     * Outputs the path found by the search algorithm.
     *
     * @param search The search algorithm instance.
     * @param key The destination vertex.
     */
    public static void outputPath(Search<String> search, String key) {
        if (search.hasPathTo(key)) {
            for (String v : search.pathTo(key)) {
                System.out.print(v + " -> ");
            }
            System.out.println();
        } else {
            System.out.println("No path found.");
        }
    }
}
