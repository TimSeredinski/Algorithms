package by.bsu.seredinski;

public class Main {

    public static void main(String[] args) {

        int[][] array = Array.createArray();
        double A[] = {(Math.sqrt(5) - 1) / 2, 0.68398858938438949384, 0.95739576375888394, 0.22495738885734};
        for (double a : A) {
            findAvgCountOfCollisions(array, a);
        }
    }

    private static void findAvgCountOfCollisions(int array[][], double A) {
        int countOfCollisions = 0;
        for (int[] arr : array) {
            HashTable hashTable = new HashTable(A);
            hashTable.insert(arr);
            countOfCollisions += hashTable.maxChainLength();
        }
        System.out.println("A = " + A + ", avgCountOfCollisions = " + countOfCollisions / 50);
    }
}
