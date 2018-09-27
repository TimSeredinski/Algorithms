package by.bsu.seredinski;

public class Algorithms {

    public static void quickSort(int[] mass, int start, int end) {
        if (start >= end) {
            return;
        }
        int curr = start - (start - end) / 2;
        curr = getCurr(mass, start, end, curr);
        sort(mass, start, curr);
        sort(mass, curr + 1, end);
    }

    public static void clearQuickSort(int[] mass, int start, int end) {
        if (start >= end) {
            return;
        }
        int curr = start - (start - end) / 2;
        curr = getCurr(mass, start, end, curr);
        clearQuickSort(mass, start, curr);
        clearQuickSort(mass, curr + 1, end);
    }

    private static int getCurr(int[] mass, int i, int j, int curr) {
        while (i < j) {
            while ((mass[i] <= mass[curr]) && i < curr) {
                i++;
            }
            while ((mass[curr] <= mass[j]) && j > curr) {
                j--;
            }
            if (i < j) {
                int a = mass[i];
                mass[i] = mass[j];
                mass[j] = a;
                if (i == curr)
                    curr = j;
                else {
                    if (j == curr)
                        curr = i;
                }
            }
        }
        return curr;
    }

    public static void insertionSort(int[] mass, int start, int end) {
        int temp, j;
        for (int i = start; i < end - start; i++) {
            temp = mass[i];
            j = i;
            while (j > start && mass[j - 1] > temp) {
                mass[j] = mass[j - 1];
                j--;
            }
            mass[j] = temp;
        }
    }


    public static void sort(int[] mass, int start, int end) {
        if ((end - start) > Main.n) {
            quickSort(mass, start, end);
        } else {
            insertionSort(mass, start, end);
        }
    }

}
