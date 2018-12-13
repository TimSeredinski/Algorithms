package by.bsu.seredinski;

import static by.bsu.seredinski.algorithm.WorkerWithSequence.findLIS;
import static by.bsu.seredinski.algorithm.WorkerWithSequence.findLSP;

public class Main {

    public static void main(String[] args) {
        String str = "afydbxfa";
        int array[] = {20, 32, 4, 33, 22, 39, 37, 99, 1, 2, 3, 4};
        findLSP(str);
        findLIS(array);
    }

}