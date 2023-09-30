/*
 *                    Cycle Detection
 * 
 *  
 *           (1)----(0)-----(3)
 *              \    |       |
 *                \  |       |
 *                  (2)     (4)
 */

import java.util.*;
import java.util.LinkedList;

public class CycleDetection {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 Edge
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        // 1 Edge
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 Edge
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 Edge
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 Edge
        graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case: 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // case: 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case: 2 -> do nothiing -> continue
        }
        return false;
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        // bfs(graph);
        System.out.println(detectCycle(graph));
    }
}

/*
 * Output:
 * True
 */
/*This Java program, named "CycleDetection," demonstrates the detection of cycles in a directed graph using Depth-First Search (DFS). Here's a short description of its key components:

1. `Edge` Class:
   - Represents an edge in the graph, containing the source (`src`) and destination (`dest`) vertices.

2. `createGraph` Method:
   - Initializes and populates an array of adjacency lists to represent the graph.
   - Defines the edges for a sample directed graph with five vertices (0 to 4).

3. `detectCycle` Method:
   - Uses DFS to detect cycles in the graph.
   - Initializes an array of boolean flags (`vis`) to keep track of visited vertices.
   - Iterates through all vertices and calls `detectCycleUtil` on unvisited vertices.
   - If `detectCycleUtil` returns true for any vertex, it indicates the presence of a cycle, and the method returns true.

4. `detectCycleUtil` Method:
   - A recursive DFS-based helper function to explore vertices and detect cycles.
   - Marks the current vertex as visited (`vis[curr] = true`).
   - Iterates through the adjacent vertices.
   - Handles three cases:
     - Case 1: If an adjacent vertex is visited and not the parent of the current vertex, it indicates a back edge and a cycle.
     - Case 2: If an adjacent vertex is visited and is the parent of the current vertex, it does nothing (continues).
     - Case 3: If an adjacent vertex is unvisited, it calls itself recursively on the adjacent vertex.
   - Returns true if a cycle is detected, otherwise false.

5. `bfs` Method (not used in this example):
   - Performs a Breadth-First Search (BFS) traversal of the graph starting from vertex 0.
   - Prints the order in which vertices are visited.

6. `main` Method:
   - The program's entry point.
   - Creates a directed graph with five vertices and specified edges using the `createGraph` method.
   - Calls `detectCycle` to check if the graph contains a cycle and prints the result.

The program demonstrates the use of DFS to detect cycles in a directed graph. In this example, the directed graph contains a cycle, and the program correctly detects it, leading to the output "True."*/
