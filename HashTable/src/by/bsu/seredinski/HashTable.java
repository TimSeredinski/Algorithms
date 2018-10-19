package by.bsu.seredinski;

public class HashTable {

    private double A;
    private ChainOfCollisions[] array;

    public HashTable(double A) {
        array = new ChainOfCollisions[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ChainOfCollisions();
        }
        this.A = A;
    }

    public void insert(int[] arr) {
        for (int anArr : arr) {
            int i = doHash(anArr);
            array[i].insertion(anArr);
        }
    }

    public int maxChainLength() {
        int length = 0;
        for (ChainOfCollisions arr : array) {
            if (length < arr.getLength())
                length = arr.getLength();
        }
        return length;
    }

    public Node search(int key) {
        int index = doHash(key);
        return array[index].search(key);
    }

    public int doHash(int value) {
        return (int) (value % 829 * A % 1 * array.length);
    }
}
