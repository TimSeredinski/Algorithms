package algorithm;

public class RabinKarp {

    private long patHash; // pattern hash value
    private int M; // pattern length
    private long Q; // modulus
    private int R; // radix
    private long RM1; // R^(M-1) % Q

    public int search(String pat, String text, Long prime) {
        M = pat.length();
        R = 256;
        Q = prime;
        RM1 = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM1 = (R * RM1) % Q;
        }
        patHash = hash(pat, M);
        int N = text.length();
        long txtHash = hash(text, M);
        if (patHash == txtHash) return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM1 * text.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + text.charAt(i)) % Q;
            if (patHash == txtHash) return i - M + 1;
        }
        return -1;
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * R + key.charAt(j)) % Q;
        return h;
    }

}
