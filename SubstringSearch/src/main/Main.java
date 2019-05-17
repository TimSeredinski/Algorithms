package main;

import algorithm.BoyerMoore;
import algorithm.BruteForce;
import algorithm.KMP;
import algorithm.RabinKarp;

import java.util.Scanner;

public class Main {
    private static String text = "ABABDABACDABABCABAB";
    private static String pattern = "ABABCABAB";

    public static void main(String[] args) {
        int result;

        System.out.println("BruteForse");
        result = BruteForce.search(pattern, text);
        printResult(result);

        System.out.println("BoyerMoore");
        BoyerMoore boyerMoore = new BoyerMoore();
        result = boyerMoore.search(pattern, text);
        printResult(result);

        System.out.println("RabinKarp");
        RabinKarp rabinKarp = new RabinKarp();
        result = rabinKarp.search(pattern, text, 7879L);
        printResult(result);

        System.out.println("KMP");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text");
        text = scanner.nextLine();
        System.out.println("Enter pattern");
        pattern = scanner.nextLine();
        KMP kmp = new KMP(pattern);
        result = kmp.search(text);
        printResult(result);
    }

    private static void printResult(int result) {
        if (result != -1) {
            System.out.println("subString on position " + (result + 1));
            for (int i = 0; i < pattern.length(); i++) {
                System.out.print(text.charAt(result + i));
            }
        } else {
            System.out.println("No subString");
        }
        System.out.println();
    }
}
