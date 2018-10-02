package by.bsu.seredinski;

public class Sorting {

    static void insertionSort(int[] mass, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j > start; j--) {
                if (mass[j - 1] > mass[j]) {
                    int tmp = mass[j - 1];
                    mass[j - 1] = mass[j];
                    mass[j] = tmp;
                }
            }
        }
    }

}
