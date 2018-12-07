package by.bsu.seredinski.entity;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int numberOfVertices;
    private int[][] matrixOfIncidence;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int[][] getMatrixOfIncidence() {
        return matrixOfIncidence;
    }

    public void setMatrixOfIncidence(int[][] matrixOfIncidence) {
        this.matrixOfIncidence = matrixOfIncidence;
    }

    public Graph(int number) {
        numberOfVertices = number;
        matrixOfIncidence = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                matrixOfIncidence[i][j] = 0;
            }
        }
    }

    public void addVertices(int amount) {
        for (int i = amount; i > 0; i--) {
            numberOfVertices++;
        }
        int[][] newMatrixOfIncidence = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i >= matrixOfIncidence.length || j >= matrixOfIncidence.length) {
                    newMatrixOfIncidence[i][j] = 0;
                } else {
                    newMatrixOfIncidence[i][j] = matrixOfIncidence[i][j];
                }
            }
        }
        setMatrixOfIncidence(newMatrixOfIncidence);
    }

    public void deleteVertex(int vertex, int[][] previousMatrix) throws IndexOutOfBoundsException {
        try {
            matrixOfIncidence = new int[numberOfVertices - 1][numberOfVertices - 1];
            System.arraycopy(previousMatrix, 1, matrixOfIncidence, 0, numberOfVertices - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Vertex is not found");
        }
    }

    public void deleteEdge(int first, int second) throws IndexOutOfBoundsException {
        try {
            matrixOfIncidence[first][second] = 0;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Edge is not found");
        }
    }

    public void addEdge(int first, int second, int weight) throws IndexOutOfBoundsException {
        try {
            first--;
            second--;
            matrixOfIncidence[first][second] = weight;
            matrixOfIncidence[second][first] = weight;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("One or both vertices are not found");
        }
    }

    public List<Integer> getConnectedVertices(int vertex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if(matrixOfIncidence[vertex][i] != 0){
                result.add(i);
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < matrixOfIncidence.length; i++) {
            for (int j = 0; j < matrixOfIncidence.length; j++) {
                System.out.print(matrixOfIncidence[i][j] + " ");
            }
            System.out.println();
        }
    }
}
