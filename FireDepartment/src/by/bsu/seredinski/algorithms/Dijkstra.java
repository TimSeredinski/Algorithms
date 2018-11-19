package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Graph;

import static java.lang.Math.min;

public class Dijkstra {
    public int[] doDijkstra(Graph graph) {
        int numberOfVertices = graph.getNumberOfVertices();
        boolean[] used = new boolean[numberOfVertices];
        int[] dist = new int[numberOfVertices];

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
                    dist[i] = min(dist[i], dist[vertex] + graph.getMatrixOfIncidence()[vertex][i]);
                }
            }
        }
        return dist;
    }

}
