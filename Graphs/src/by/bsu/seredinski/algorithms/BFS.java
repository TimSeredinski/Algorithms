package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    private static int amountOfComponents;

    private static void setLevelsToTheVertices(Graph graph, int vertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        graph.setLevel(vertex, 0);
        amountOfComponents++;
        System.out.println("Component " + amountOfComponents + ": ");
        System.out.println("Level of vertex " + (vertex + 1) + " is equal " + 1);
        while (!queue.isEmpty()) {
            vertex = ((ArrayDeque<Integer>) queue).pop();
            for (int i = 0; i < graph.getConnectedVertices()[vertex].size(); i++) {
                if (graph.getLevel(graph.getConnectedVertices()[vertex].get(i)) == -1) {
                    queue.add(graph.getConnectedVertices()[vertex].get(i));
                    graph.setLevel(graph.getConnectedVertices()[vertex].get(i), graph.getLevel(vertex) + 1);
                    System.out.println("Level of vertex " + (graph.getConnectedVertices()[vertex].get(i) + 1) + " is equal " + (graph.getLevel(vertex) + 2));
                }
            }
        }
    }

    public static void doBFS(Graph graph) {
        amountOfComponents = 0;
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            graph.setLevel(i, -1);
        }

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (graph.getLevel(i) == -1) {
                setLevelsToTheVertices(graph, i);
            }
        }
    }


}
