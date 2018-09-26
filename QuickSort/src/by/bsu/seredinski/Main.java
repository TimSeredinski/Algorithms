package by.bsu.seredinski;

import java.io.IOException;

import static by.bsu.seredinski.Algorithms.*;

public class Main {
public static int n = 20;
    public static void main(String[] args) throws IOException {

        //Array.writeToFile(Array.createArr());

        while (n > 6) {
            long startTime = System.nanoTime();
            int[][] mass = Array.readFromFile();
            for (int i = 0; i < mass.length; i++) {
                sort(mass[i], 0, mass[i].length - 1);
            }
            long timeSpent = System.nanoTime() - startTime;
            System.out.println("Время сортировки при n = " + n + " - "+ timeSpent + " наносекунд");
            n--;
        }
    }

}
