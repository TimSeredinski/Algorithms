package by.bsu.seredinski.entity;

public class Edge {

    private int firstVertex;
    private int secondVertex;
    private int weight;

    public Edge() {
    }

    public Edge(int firstVertex, int secondVertex, int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + (firstVertex + 1) +
                "," + (secondVertex + 1) +
                ") = " + weight;
    }
}
