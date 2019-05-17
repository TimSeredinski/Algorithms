package algorithm;

public class KMP {
    private String pat;
    private int R;
    int[][] dfa;

    public KMP(String pat) {
        R = 256;
        this.pat = pat;
        int length = pat.length();
        dfa = new int[R][length];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < length; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String text) {
        int i, j, N = text.length();
        int M = dfa[0].length;
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[text.charAt(i)][j];
        if (j == M) return i - M;
        return -1;
    }

}
