/*Shortest path to reach one prime to other by changing single digit at a time*/

import java.io.*;
import java.util.*;

class Graph {
private int V;
private LinkedList<Integer>[] l;

@SuppressWarnings("unchecked") Graph(int v)
{
	V = v;
	l = new LinkedList[v];
	for (int i = 0; i < v; i++)
	l[i] = new LinkedList<Integer>();
}

void addedge(int V1, int V2)
{
	l[V1].add(V2);
	l[V2].add(V1);
}

static void SieveOfEratosthenes(LinkedList<Integer> v)
{

	int n = 9999;
	Boolean prime[] = new Boolean[n + 1];
	Arrays.fill(prime, true);

	for (int p = 2; p * p <= n; p++) {

	if (prime[p] == true) {

		for (int i = p * p; i <= n; i += p)
		prime[i] = false;
	}
	}

	for (int p = 1000; p <= n; p++) {
	if (prime[p])
		v.add(p);
	}
}

int bfs(int in1, int in2)
{
	int visited[] = new int[V];
	Arrays.fill(visited, 0);
	Queue<Integer> que = new LinkedList<Integer>();
	visited[in1] = 1;
	que.add(in1);

	while (!que.isEmpty()) {
	int p = que.poll();
	for (int i : l[p]) {
		if (visited[i] == 0) {
		visited[i] = visited[p] + 1;
		que.add(i);
		}
		if (i == in2) {
		return visited[i] - 1;
		}
	}
	}

	return 0;
}

static Boolean compare(int num1, int num2)
{
	// To compare the digits
	char[] s1 = (Integer.toString(num1)).toCharArray();
	char[] s2 = (Integer.toString(num2)).toCharArray();
	int c = 0;
	if (s1[0] != s2[0])
	c++;
	if (s1[1] != s2[1])
	c++;
	if (s1[2] != s2[2])
	c++;
	if (s1[3] != s2[3])
	c++;

	return (c == 1);
}

static int shortestPath(int num1, int num2)
{
	LinkedList<Integer> pset
	= new LinkedList<Integer>();
	SieveOfEratosthenes(pset);

	Graph g = new Graph(pset.size());
	for (int i = 0; i < pset.size(); i++) {
	for (int j = i + 1; j < pset.size(); j++) {
		if (compare(pset.get(i), pset.get(j)))
		g.addedge(i, j);
	}
	}

	int in1 = 0, in2 = 0;
	for (int j = 0; j < pset.size(); j++) {
	if (pset.get(j) == num1)
		in1 = j;
	}

	for (int j = 0; j < pset.size(); j++) {
	if (pset.get(j) == num2)
		in2 = j;
	}

	return g.bfs(in1, in2);
}

public static void main(String[] args)
{
	int num1 = 1033, num2 = 8179;
	int ans = shortestPath(num1, num2);
	System.out.println(ans);
}
}

