package algorithm;

public class BoyerMoore {

    private int R;

    public int search(String pattern, String text) {
        int textLength = text.length();
        int patternLength = pattern.length();
        R = 256;
        int[] right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < patternLength; j++) {
            right[pattern.charAt(j)] = j;
        }
        int skip;
        for (int i = 0; i <= textLength - patternLength; i += skip) {
            skip = 0;
            for (int j = patternLength - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }

}
