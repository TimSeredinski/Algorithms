package by.bsu.seredinski.entity;

public class DSU {

    private int[] rank;

    public DSU(int numOfVertices) {
        rank = new int[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            rank[i] = i;
        }
    }

    public int find(int vertex) {
        if (rank[vertex] == vertex)
            return vertex;
        return rank[vertex] = find(rank[vertex]);
    }

    public boolean unite(int firstVertex, int secondVertex) {
        firstVertex = find(firstVertex);
        secondVertex = find(secondVertex);
        if(firstVertex == secondVertex)
            return false;
        if(firstVertex < secondVertex)
            rank[firstVertex] = secondVertex;
        if(firstVertex > secondVertex)
            rank[secondVertex] = firstVertex;
        return true;
    }
}
