package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Graph;

import java.util.Arrays;

import static java.lang.Math.min;

public class Dijkstra {

    private int[] doDijkstra(Graph graph, int vertexForCounting) {
        int numberOfVertices = graph.getNumberOfVertices();
        boolean[] used = new boolean[numberOfVertices];
        int[] dist = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = 999;
        }
        dist[vertexForCounting] = 0;

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

    public int[] findMinArrayOfDistances(Graph graph) {
        int[] arrayWithMinLongestWay = new int[graph.getNumberOfVertices()];
        int[] array;
        int minElement = 999;
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            array = doDijkstra(graph, i);
            System.out.println(Arrays.toString(array));
            int lengthOfMaxElement = getMaxElement(array);
            if (minElement > lengthOfMaxElement) {
                minElement = lengthOfMaxElement;
                System.arraycopy(array, 0, arrayWithMinLongestWay, 0, array.length);
            }
            else if(minElement == lengthOfMaxElement){
                if(getLengthOfAllWays(arrayWithMinLongestWay) > getLengthOfAllWays(array)){
                    System.arraycopy(array, 0, arrayWithMinLongestWay, 0, array.length);
                }
            }
        }
        // refactor make sout beautiful
        System.out.println(getMaxElement(arrayWithMinLongestWay));
        return arrayWithMinLongestWay;
    }

    private int getMaxElement(int[] array) {
        int max = 0;
        for (int arr : array) {
            if (max < arr) {
                max = arr;
            }
        }
        return max;
    }

    private int getLengthOfAllWays(int[] array) {
        int length = 0;
        for (int arr : array) {
            length += arr;
        }
        return length;
    }

}
