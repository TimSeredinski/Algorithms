package by.bsu.seredinski.entity;

import java.util.LinkedList;
import java.util.List;

public class EdgesOfGraph {

    private List<Edge> edges;

    public EdgesOfGraph() {
        edges = new LinkedList<>();
    }

    public void addEdge(Edge edge) {
        if(!edges.contains(edge))
            edges.add(edge);
    }

    public void deleteEdge(Edge edge) {
        if (edges.contains(edge))
            edges.remove(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdgesOfGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if(matrix[j][i]!=0)
                    edges.add(new Edge(i, j, matrix[j][i]));
            }
        }
    }

    @Override
    public String toString() {
        return "Minimal spanning tree: " + edges;
    }
}
