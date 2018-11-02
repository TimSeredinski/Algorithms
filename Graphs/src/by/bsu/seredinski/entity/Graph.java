package by.bsu.seredinski.entity;

import java.util.LinkedList;

public class Graph implements Cloneable{

    private int numberOfVertices;
    private LinkedList<Integer>[] connectedVertices;
    private int[] level;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getLevel(int index) {
        return level[index];
    }

    public void setLevel(int index, int level) {
        this.level[index] = level;
    }

    public Graph clone() throws CloneNotSupportedException{
        Graph clonedObj = (Graph) super.clone();
        clonedObj.numberOfVertices = this.numberOfVertices;
        clonedObj.connectedVertices = this.connectedVertices.clone();
        return clonedObj;
    }

    public LinkedList<Integer>[] getConnectedVertices() {
        return connectedVertices;
    }

    public Graph() {
        numberOfVertices = 0;
        connectedVertices = new LinkedList[numberOfVertices];
        level = new int[0];
    }

    public void addVertices(int amount) {
        for (int i = amount; i > 0; i--) {
            numberOfVertices++;
            changeSizeOfConnectedVertices(connectedVertices);
        }
        level = new int[numberOfVertices];
    }

    public void deleteVertex(int vertex) throws IndexOutOfBoundsException {
        try {
            for (int i = connectedVertices[vertex].size(); i > 0; i--) {
                deleteEdge(vertex, connectedVertices[vertex].get(i - 1));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Vertex is not found");
        }
    }

    public void deleteEdge(int first, int second) throws IndexOutOfBoundsException {
        try {
            connectedVertices[first].remove(connectedVertices[first].indexOf(second));
            connectedVertices[second].remove(connectedVertices[second].indexOf(first));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Edge is not found");
        }
    }

    private void changeSizeOfConnectedVertices(LinkedList<Integer>[] previousList) {
        connectedVertices = new LinkedList[numberOfVertices];
        System.arraycopy(previousList, 0, connectedVertices, 0, numberOfVertices - 1);
        connectedVertices[numberOfVertices - 1] = new LinkedList<>();
    }

    public void addEdge(int first, int second) throws IndexOutOfBoundsException {
        try {
            connectedVertices[first].add(second);
            connectedVertices[second].add(first);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("One or both vertices are not found");
        }
    }

    public void print() {
        if (numberOfVertices == 0) {
            System.out.println("Graph is empty");
            return;
        }
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print("Vertex " + (i + 1));
            for (int j = 0; j < connectedVertices[i].size(); j++) {
                System.out.print("->" + (connectedVertices[i].get(j) + 1));
            }
            System.out.println();
        }
    }
}

