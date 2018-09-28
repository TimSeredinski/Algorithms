package by.bsu.seredinski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Array {

    public static int[][] createArr() {
        int[][] array = new int[50][100000];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) Math.round(Math.random() * 1000000000);
            }
        }
        return array;
    }

    public static void writeToFile(int[][] array) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("Text.txt"));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                fileWriter.write(array[i][j] + " ");
                fileWriter.flush();
            }
        }
    }

    public static void writeResult(int n, long time) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("result.txt"));
        fileWriter.write("Гибрибдая сортировка быстрее при n = " + n + " на " + time + " наносекунд");
        fileWriter.flush();
    }

    public static int[][] readFromFile() throws FileNotFoundException {
        Scanner scannerFile = new Scanner(new File("Text.txt"));
        int[][] mass = new int[50][100000];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                if (scannerFile.hasNextInt())
                    mass[i][j] = scannerFile.nextInt();
            }
        }
        return mass;
    }
}
