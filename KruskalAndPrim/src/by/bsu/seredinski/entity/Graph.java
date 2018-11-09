package by.bsu.seredinski.entity;

public class Graph {

    private int numberOfVertices;
    private int[][] matrixOfIncidence;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int[][] getMatrixOfIncidence() {
        return matrixOfIncidence;
    }

    public Graph(int number) {
        matrixOfIncidence = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                matrixOfIncidence[i][j] = 0;
            }
        }
    }

    public void addVertices(int amount) {
        for (int i = amount; i > 0; i--) {
            numberOfVertices++;
            changeSizeOfConnectedVertices(matrixOfIncidence);
        }
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

    private void changeSizeOfConnectedVertices(int[][] previousMatrix) {
        matrixOfIncidence = new int[numberOfVertices][numberOfVertices];
        System.arraycopy(previousMatrix, 0, matrixOfIncidence, 0, numberOfVertices - 1);
        matrixOfIncidence[numberOfVertices - 1] = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            matrixOfIncidence[numberOfVertices - 1][i] = -1;
            matrixOfIncidence[i][numberOfVertices - 1] = -1;
        }
    }

    public void addEdge(int first, int second, int weight) throws IndexOutOfBoundsException {
        try {
            first--;
            second--;
            if (first > second) {
                matrixOfIncidence[first][second] = weight;
            }
            else {
                matrixOfIncidence[second][first] = weight;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("One or both vertices are not found");
        }
    }

    public void print() {
        for (int i = 0; i < matrixOfIncidence.length; i++) {
            for (int j = 0; j < matrixOfIncidence.length; j++) {
                System.out.print(matrixOfIncidence[j][i] + " ");
            }
            System.out.println();
        }
    }
}
