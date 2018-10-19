package by.bsu.seredinski;

public class Quadratic {

    public NodeForQuadtaric[] array;
    public static int maxI;

    public Quadratic(int length) {
        array = new NodeForQuadtaric[length];
        for (int i = 0; i < length; i++) {
            array[i] = new NodeForQuadtaric();
        }
        maxI = 1;
    }

    public int doHash(int value) {
        return (int) (((value % 829) * (Math.sqrt(5) - 1) / 2) % 1 * Main.size);
    }

    public void insert(int[] arr) {
        for (int anArr : arr) {
            insert(anArr);
        }
    }

    private void insert(int value) {
        int i = 1;
        int index = doHash(value);
        int newIndex = index;
        while (array[newIndex].getElement() != -1 && array[newIndex].getElement() != value) {
            newIndex = (index + i * i) % Main.size;
            i++;
        }
        if (array[newIndex].getElement() != value) {
            array[newIndex].setElement(value);
            array[newIndex].setKey(index);
        }
        if (maxI < i) {
            maxI = i;
        }
    }

    public int search(int value) {

        int i = 1;
        int index = doHash(value);
        int newIndex = index;
        while (array[newIndex].getElement() != -1 && array[newIndex].getElement() != value) {
            newIndex = (index + i * i) % Main.size;
            i++;
        }
        if (array[newIndex].getElement() != value) {
            return newIndex;
        }
        return -1;
    }

    public void display() {
        for (NodeForQuadtaric arr : array) {
            System.out.print(arr.getElement() + " ");
        }
    }

}
