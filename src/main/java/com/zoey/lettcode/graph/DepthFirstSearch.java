package com.zoey.lettcode.graph;
// DFS algorithm in Java

import java.util.*;

class DepthFirstSearch {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // DepthFirstSearch creation
    DepthFirstSearch(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String args[]) {
        DepthFirstSearch g = new DepthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        Iterator<LinkedList<Integer>> iterator = Arrays.stream(g.adjLists).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }


        System.out.println("Following is Depth First Traversal");

        g.DFS(2);
    }
}
