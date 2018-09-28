package by.bsu.seredinski;

public class Algorithms {

    public static int quickSort(int[] mass, int start, int end) {
        if (start < end) {
            int curr = start - (start - end) / 2;
            curr = getCurr(mass, start, end, curr);
            return curr;
        }
        return 0;
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


    public static void sort(int[] mass, int start, int end) {
        if ((end - start) > Main.n) {
            int curr = quickSort(mass, start, end);
            sort(mass, start, curr);
            sort(mass, curr + 1, end);
        } else {
            insertionSort(mass, start, end);
        }
    }

}
