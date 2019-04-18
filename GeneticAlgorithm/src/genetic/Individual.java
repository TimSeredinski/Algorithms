package genetic;

import java.util.Random;

public class Individual {

    private int u;
    private int w;
    private int x;
    private int y;
    private int z;
    private int Fa;

    @Override
    public String toString() {
        return "Fa = " + getFa() + "; (" + getU() + "," + getW() + "," + getX() + "," + getY() + "," + getZ() + ")";
    }

    Individual(int from, int to) {
        Random random = new Random();
        setU(from + random.nextInt(to - from + 1));
        setW(from + random.nextInt(to - from + 1));
        setX(from + random.nextInt(to - from + 1));
        setY(from + random.nextInt(to - from + 1));
        setZ(from + random.nextInt(to - from + 1));
    }

    Individual(int u, int w, int x, int y, int z) {
        setU(u);
        setW(w);
        setX(x);
        setY(y);
        setZ(z);
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    int getZ() {
        return z;
    }

    void setZ(int z) {
        this.z = z;
    }

    int getU() {
        return u;
    }

    void setU(int u) {
        this.u = u;
    }

    int getW() {
        return w;
    }

    void setW(int w) {
        this.w = w;
    }

    int getFa() {
        return Fa;
    }

    void setFa(int fa) {
        Fa = fa;
    }
}
