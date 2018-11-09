package by.bsu.seredinski.entity;

public class Edge {

    private int firstVertex;
    private int secondVertex;
    private int weight;

    public Edge(int firstVertex, int secondVertex, int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "(" + (firstVertex + 1) +
                "," + (secondVertex + 1) +
                ") = " + weight +
                '}';
    }
}
