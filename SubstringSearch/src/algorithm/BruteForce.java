package algorithm;

public class BruteForce {

    public static int search(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            if (j == patternLength) return i;
        }
        return -1;
    }

}
