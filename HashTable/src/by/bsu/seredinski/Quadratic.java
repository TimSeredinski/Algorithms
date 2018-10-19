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

    private int doHash(int value, int i) {
        return (value % 829 + i * i) % array.length;
    }

    public void insert(int[] arr) {
        for (int anArr : arr) {
            insert(anArr);
        }
    }

    private void insert(int value) {
        int i = 1, a = value;
        int index = doHash(value, i);
        while (array[index].getElement() != 0) {
            i++;
            index = doHash(a, i);
            a = index;
        }
        if (array[index].getElement() == 0) {
            array[index].setElement(value);
            array[index].setKey(index);
        }
        if (maxI < i) {
            maxI = i;
        }
    }

    public NodeForQuadtaric search(int key) {
        if (key < array.length)
            return array[key];
        return null;
    }

    public void display() {
        for (NodeForQuadtaric arr : array) {
            System.out.print(arr.getElement() + " ");
        }
    }

}
