package by.bsu.seredinski;

import java.io.IOException;

import static by.bsu.seredinski.Algorithms.clearQuickSort;
import static by.bsu.seredinski.Algorithms.sort;

public class Main {
    public static int n = 200;

    public static void main(String[] args) throws IOException {

        //Array.writeToFile(Array.createArr());

        while (n > 6) {
            int[][] mass1 = Array.readFromFile();
            int[][] mass2 = Array.readFromFile();
            long avgQuickSort = 0;
            long avgHybridSort = 0;
            for (int i = 0; i < mass2.length; i++) {
                long startTimeQuickSort = System.nanoTime();
                clearQuickSort(mass2[i], 0, mass2[i].length - 1);
                long timeSpentQuickSort = System.nanoTime() - startTimeQuickSort;
                avgQuickSort += timeSpentQuickSort;
            }

            avgQuickSort /= mass2.length;

            for (int i = 0; i < mass1.length; i++) {
                long startTimeHybrid = System.nanoTime();
                sort(mass1[i], 0, mass1[i].length - 1);
                long timeSpentHybrid = System.nanoTime() - startTimeHybrid;
                avgHybridSort += timeSpentHybrid;
            }

            avgHybridSort /= mass1.length;

            if (avgHybridSort < avgQuickSort) {
                System.out.println("n = " + n + " гибридная сортировка быстрее на " + (avgQuickSort - avgHybridSort) + " наносекунд");
            } else {
                System.out.println("n = " + n + " " + (avgHybridSort - avgQuickSort));
            }
            n--;
        }
    }

}
