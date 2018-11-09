package by.bsu.seredinski.algorithms;

import by.bsu.seredinski.entity.DSU;
import by.bsu.seredinski.entity.Edge;
import by.bsu.seredinski.entity.EdgesOfGraph;
import by.bsu.seredinski.entity.Graph;

public class Kruskal {
    public static EdgesOfGraph doKruskal(Graph graph) {
        EdgesOfGraph edges = new EdgesOfGraph();
        edges.setEdgesOfGraph(graph.getMatrixOfIncidence());
        DSU dsu = new DSU(graph.getNumberOfVertices());
        EdgesOfGraph minimumSpanningTree = new EdgesOfGraph();
        for (Edge edge : edges.getEdges()) {
            if (dsu.unite(edge.getFirstVertex(), edge.getSecondVertex()))
                minimumSpanningTree.addEdge(edge);
        }
        return minimumSpanningTree;
    }
}
