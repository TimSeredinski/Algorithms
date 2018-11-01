package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class EulerianCycle {


    public static Queue<Integer> findCycle(Graph graph) {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!(graph.getConnectedVertices()[i].size() % 2 == 0)) {
                return null;
            }
        }
        System.out.println("Starting build cycle...");

        Graph copyOfGraph = graph;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        stack.push(0);
        while (!stack.isEmpty()) {
            System.out.println(stack);
            int vertex = stack.peek();
            if (copyOfGraph.getConnectedVertices()[vertex].size() > 0) {
                stack.push(copyOfGraph.getConnectedVertices()[vertex].getFirst());
                copyOfGraph.deleteEdge(vertex, copyOfGraph.getConnectedVertices()[vertex].getFirst());
            } else {
                queue.add(stack.pop() + 1);
            }
        }
        return queue;
    }
}
