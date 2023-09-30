/*Problem Statement: Cycle Detection in Directed Graph

You are given a directed graph represented as a collection of edges. Your task is to write a C++ program to detect whether this graph contains a cycle or not.

A directed graph consists of a set of vertices and a set of directed edges, where each edge has a source vertex and a destination vertex. A cycle in a directed graph is a sequence of vertices such that there is a directed edge from each vertex to the next, and the last vertex in the sequence has a directed edge back to the first vertex, forming a closed loop.

Your program should take the following inputs:

The number of vertices (V) in the graph.
A list of directed edges, where each edge is represented as a pair of source and destination vertices.
Your program should output whether the given directed graph contains a cycle or not.


  Your C++ program should include the following components:

A data structure to represent the graph.
A function to add directed edges to the graph.
A function that uses depth-first search (DFS) or breadth-first search (BFS) to detect cycles in the graph.
Proper error handling to handle invalid inputs.
Number of vertices (V): 4
Directed Edges:
0 -> 1
1 -> 2
2 -> 3
3 -> 0
The graph contains a cycle.
Number of vertices (V): 3
Directed Edges:
0 -> 1
1 -> 2
The graph does not contain a cycle.*/

