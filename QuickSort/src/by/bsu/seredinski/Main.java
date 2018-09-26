package by.bsu.seredinski;

import java.io.IOException;

import static by.bsu.seredinski.Algorithms.clearQuickSort;
import static by.bsu.seredinski.Algorithms.sort;

public class Main {
    public static int n = 200;
    private static long timeSpentHybrid;
    private static long timeSpentQuickSort;

    public static void main(String[] args) throws IOException {

        //Array.writeToFile(Array.createArr());

        while (n > 6) {
            int[][] mass1 = Array.readFromFile();
            int[][] mass2 = Array.readFromFile();
            for (int i = 0; i < mass1.length; i++) {
                long startTimeQuickSort = System.nanoTime();
                clearQuickSort(mass2[i], 0, mass2[i].length - 1);
                timeSpentQuickSort = System.nanoTime() - startTimeQuickSort;
                long startTimeHybrid = System.nanoTime();
                sort(mass1[i], 0, mass1[i].length - 1);
                timeSpentHybrid = System.nanoTime() - startTimeHybrid;
            }
            if (timeSpentHybrid < timeSpentQuickSort) {
                System.out.println("n = " + n + " гибридная сортировка быстрее на " + (timeSpentQuickSort - timeSpentHybrid) + " наносекунд");
            } else {
                System.out.println("n = " + n + " " + (timeSpentHybrid - timeSpentQuickSort));
            }
            n--;
        }
    }

}
