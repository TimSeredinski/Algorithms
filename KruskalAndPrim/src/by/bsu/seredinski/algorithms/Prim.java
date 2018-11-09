package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Edge;
import by.bsu.seredinski.entity.EdgesOfGraph;
import by.bsu.seredinski.entity.Graph;

import static java.lang.Math.min;

public class Prim {

    public EdgesOfGraph doPrim(Graph graph) {
        EdgesOfGraph minimumSpanningTree = new EdgesOfGraph();
        int numberOfVertices = graph.getNumberOfVertices();
        boolean[] used = new boolean[numberOfVertices];
        int[] dist = new int[numberOfVertices];
        Edge edge = null;

        dist[0] = 0;
        for (int i = 1; i < numberOfVertices; i++) {
            dist[i] = 999;
        }

        while (true) {
            int vertex = -1;
            for (int i = 0; i < numberOfVertices; i++) {
                if (!used[i] && dist[i] < 999 && (vertex == -1 || dist[vertex] > dist[i])) {
                    vertex = i;
                }
            }
            if (vertex == -1) break;
            used[vertex] = true;
            for (int i = 0; i < numberOfVertices; i++) {
                if (!used[i] && graph.getMatrixOfIncidence()[vertex][i] < 999 && graph.getMatrixOfIncidence()[vertex][i] != 0) {
                    dist[i] = min(dist[i], graph.getMatrixOfIncidence()[vertex][i]);
                    edge = new Edge(vertex, i, dist[i]);
                }
            }
            System.out.println(edge);
            minimumSpanningTree.addEdge(edge);
        }
        return minimumSpanningTree;
    }
}
