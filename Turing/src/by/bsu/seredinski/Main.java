package by.bsu.seredinski;

import java.util.Scanner;

public class Main {

    /*2.45 Считая непустое слово P записью положительного
     троичного числа, уменьшить это число на 1.*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите положительное троичное число");
        String inputWord = scanner.nextLine();
        char[] str = ("#" + inputWord + "#").toCharArray();
        System.out.println(str);

        String[][][] arrayOfConditions = {
                {{"11+1"}, {"22+1"}, {"00+1"}, {"##-2"}},           //q1
                {{"21-7"}, {"10-7"}, {"02-2"}, {"##-2"}}            //q2
        };
        int q = 0; //Номер текущего состояния
        for (int i = 1; i < str.length; ) {
            for (int j = 0; j < arrayOfConditions[0].length; j++) {
                char[] action = arrayOfConditions[q][j][0].toCharArray();
                if (str[i] == action[0]) {
                    str[i] = action[1];
                    if (action[2] == '+') {
                        i++;
                    }
                    if (action[2] == '-') {
                        i--;
                    }
                    q = Integer.parseInt(String.valueOf(action[3])) - 1;
                    break;
                }
            }
            if (q == 6) {
                break;
            }
        }
        System.out.println(str);
    }

}
