package by.bsu.seredinski;

public class Array {

    static void createArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            array[i] = 1 + (int) (Math.random() * 20);
        }
    }

    static void printArray(int []array){
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
