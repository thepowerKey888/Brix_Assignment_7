/**
 * Write a program that takes as input a directed weighted graph
 * and two of its vertices, u and w
 * and prints every simple path that goes from u to w with a length of 5.
 *
 * Use a Minimum Cost algorithm and modify it so it returns every simple path
 * from the start and end with a length of 5.
 */

import java.util.*;

public class EveryPath {
    private int V;
    private LinkedList<Edge>[] adjacent;

    class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    EveryPath(int v) {
        V = v;
        adjacent = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacent[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v, int weight) {
        adjacent[u].add(new Edge(v, weight));
    }

    public void allPaths(int u, int w, int[] path, int length) {
        if (length == 5 && u == w) {

                for (int i = 0; i < length; i++) {
                    System.out.print(path[i] + " ");
                }
                System.out.println(w);

            return;
        }

        for (Edge e : adjacent[u]) {
            int v = e.destination;
            int weight = e.weight;
            path[length] = v;
            allPaths(v, w, path, length + 1);
        }
    }

    public void printPaths(int u, int w) {
        int[] path = new int[6];
        path[0] = u;
        allPaths(u, w, path, 1);
    }

//    public void printOgGraph() {
//        System.out.println("Graph:");
//        for (int i = 0; i < V; ++i) {
//            StringBuilder row = new StringBuilder();
//            for (int j = 0; j < V; ++j) {
//                boolean found = false;
//                for (Edge e : adjacent[i]) {
//                    if (e.destination == j) {
//                        row.append(e.weight);
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    row.append("0");
//                }
//            }
//            System.out.println(row);
//        }
//    }


    public static void main(String[] args) {
        EveryPath graph = new EveryPath(6);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 1);

        System.out.println();
        //System.out.println("Original Graph:");
        //graph.printOgGraph();

        System.out.println();
        int u = 0;
        int w = 5;

        System.out.println();
        System.out.println("Paths from " + u + " to " + w + " with length 5:");
        graph.printPaths(u, w);

    }
}

