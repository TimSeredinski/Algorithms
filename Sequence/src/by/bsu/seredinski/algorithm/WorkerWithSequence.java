package by.bsu.seredinski.algorithm;

import static java.lang.Math.max;

public class WorkerWithSequence {

    public static void findLSP(String str) {
        int n = str.length();
        int[][] L = new int[n][n];
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }
        for (int lengthOfSubString = 2; lengthOfSubString <= n; lengthOfSubString++) {
            for (int i = 0; i < n - lengthOfSubString + 1; i++) {
                int j = i + lengthOfSubString - 1;
                if (str.charAt(i) == str.charAt(j) && lengthOfSubString == 2) {
                    L[i][j] = 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        L[i][j] = L[i + 1][j - 1] + 2;
                    } else {
                        L[i][j] = max(L[i][j - 1], L[i + 1][j]);
                    }
                }
            }
        }
        System.out.println("Max length of substring: " + L[0][n - 1]);
    }

    public static void findLIS(int[] array) {
        int[] LIS = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                max = 1;
            }
            LIS[i] = max;
        }
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }
        StringBuilder path = new StringBuilder(array[index] + " ");
        int res = result - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (LIS[i] == res) {
                path.insert(0, array[i] + " ");
                res--;
            }
        }
        System.out.println("Max length of subsequence: " + result);
        System.out.println("Subsequence: " + path);
    }

}