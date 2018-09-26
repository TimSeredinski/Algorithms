package by.bsu.seredinski;

public class Algorithms {

    public static int[] quickSort(int[] mass, int start, int end) {
        int i = start;
        int j = end;
        if (i >= j) {
            return mass;
        }
        int curr = i - (i - j) / 2;
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
        sort(mass, start, curr);
        sort(mass, curr + 1, end);
        return mass;
    }

    public static int[] insertIntoSort(int[] mass) {
        int temp, j;
        for (int i = 0; i < mass.length - 1; i++) {
            if (mass[i] > mass[i + 1]) {
                temp = mass[i + 1];
                mass[i + 1] = mass[i];
                j = i;
                while (j > 0 && temp < mass[j - 1]) {
                    mass[j] = mass[j - 1];
                    j--;
                }
                mass[j] = temp;
            }
        }
        return mass;
    }

    public static void sort(int[] mass, int start, int end) {
        if (mass.length > Main.n) {
            quickSort(mass, start, end);
        } else
            insertIntoSort(mass);
    }
}
