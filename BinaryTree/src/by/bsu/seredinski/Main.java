package by.bsu.seredinski;

public class Main {

    public static void main(String[] args) {
        int[] array = {3, 4, 9, 14, 24, 11, 5, 1, 19};
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
    }
}
