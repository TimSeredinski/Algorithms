package by.bsu.seredinski.entity;

public class DSU {

    private int[] parent;
    private int[] rank;

    public DSU(int numOfVertices) {
        parent = new int[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int vertex) {
        if (parent[vertex] == vertex)
            return vertex;
        return parent[vertex] = find(parent[vertex]);
    }

    public void unite(int firstVertex, int secondVertex) {
        firstVertex = find(firstVertex);
        secondVertex = find(secondVertex);
        if (rank[firstVertex] < rank[secondVertex])
            parent[firstVertex] = secondVertex;
        else {
            parent[secondVertex] = firstVertex;
            if (rank[firstVertex] == rank[secondVertex])
                ++rank[firstVertex];
        }
    }
}
