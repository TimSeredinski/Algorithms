package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    private static void setLevelsToTheVertices(Graph graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        graph.setLevel(0, 0);

        for (int i = 1; i < graph.getNumberOfVertices(); i++) {
            graph.setLevel(i, -1);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue);
            int vertex = ((ArrayDeque<Integer>) queue).pop();
            for (int i = 0; i < graph.getConnectedVertices()[vertex].size(); i++) {
                if (graph.getLevel(graph.getConnectedVertices()[vertex].get(i)) == -1) {
                    queue.add(graph.getConnectedVertices()[vertex].get(i));
                    graph.setLevel(graph.getConnectedVertices()[vertex].get(i), vertex + 1);
                }
            }
            ((ArrayDeque<Integer>) queue).removeFirst();
        }
    }

    public static void doBFS(Graph graph) {
        setLevelsToTheVertices(graph);
        printBFSLevels(graph);
    }

    private static void printBFSLevels(Graph graph) {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            System.out.println("Level of vertex " + (i + 1) + " is equal " + (graph.getLevel(i) + 1));
        }
    }

}
