Question 1:

Implement a Java program to perform a Depth-First Search (DFS) traversal on a directed graph and print the vertices in the order they were visited.

Code:
import java.util.*;

public class DFSGraphTraversal {

    static class Graph {
        private int vertices;
        private Map<Integer, List<Integer>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                adjList.put(i, new LinkedList<>());
            }
        }

        void addEdge(int source, int destination) {
            adjList.get(source).add(destination);
        }

        void DFS(int startVertex) {
            Set<Integer> visited = new HashSet<>();
            DFSUtil(startVertex, visited);
        }

        private void DFSUtil(int vertex, Set<Integer> visited) {
            visited.add(vertex);
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        System.out.println("DFS traversal starting from vertex 0:");
        graph.DFS(0);
    }
}


Question 2:

Write a Java program to perform a Breadth-First Search (BFS) traversal on an undirected graph and print the vertices in the order they were visited.

Code:
import java.util.*;

public class BFSUndirectedGraph {

    static class Graph {
        private int vertices;
        private Map<Integer, List<Integer>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                adjList.put(i, new LinkedList<>());
            }
        }

        void addEdge(int source, int destination) {
            adjList.get(source).add(destination);
            adjList.get(destination).add(source); // For an undirected graph
        }

        void BFS(int startVertex) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            visited.add(startVertex);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (int neighbor : adjList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("BFS traversal starting from vertex 0:");
        graph.BFS(0);
    }
}
