package by.bsu.seredinski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*2.45 Считая непустое слово P записью положительного
     троичного числа, уменьшить это число на 1.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите положительное троичное число");
        String inputWord = scanner.nextLine();
        char[] str = ("#" + inputWord + "#").toCharArray();
        System.out.println(str);
        String[][][] arrayOfConditions1 = {
                {{"11+0"}, {"22+0"}, {"00+0"}, {"##-1"}},           //q1
                {{"21-7"}, {"10-7"}, {"02-1"}, {"##-1"}}            //q2
        };
        changeStringUsingConditions(str, arrayOfConditions1);

        ////////////////////////////////////////////////////////////////

        /*1.32Считая слово P записью числа в единичной системе счисления,
     получить запись этого числа в троичной системе*/
        System.out.println("Введите положительное число в единичной системе счисления, используя '|'");
        inputWord = scanner.nextLine();
        StringBuilder partOfStr = new StringBuilder();
        for (int i = 0; i < inputWord.length(); i++) {
            partOfStr.append("0");
        }
        str = ("#" + inputWord + "#" + partOfStr + "#").toCharArray();
        System.out.println(str);
        String[][][] arrayOfConditions2 = {
                {{"|#+1"}, {"11+0"}, {"22+0"}, {"00+0"}, {"##+7"}},           //q0
                {{"||+1"}, {"11+1"}, {"22+1"}, {"00+1"}, {"##+2"}},           //q1
                {{"||+2"}, {"22+2"}, {"11+2"}, {"00+2"}, {"##-3"}},           //q2
                {{"||+3"}, {"20-3"}, {"12-4"}, {"01-4"}, {"##-4"}},           //q3
                {{"||+4"}, {"22-4"}, {"11-4"}, {"00-4"}, {"##-5"}},           //q4
                {{"||-5"}, {"22-5"}, {"11-5"}, {"00-5"}, {"##+0"}},           //q5
        };
        changeStringUsingConditions(str, arrayOfConditions2);
    }

    private static void changeStringUsingConditions(char[] str, String[][][] arrayOfConditions) {
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
                    q = Integer.parseInt(String.valueOf(action[3]));
                    break;
                }
            }
            if (q == 7) {
                break;
            }
        }
        System.out.println(str);
    }

}