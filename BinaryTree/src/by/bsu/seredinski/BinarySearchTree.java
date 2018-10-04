package by.bsu.seredinski;

public class BinarySearchTree {

    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = doInsert(root, value);
    }

    Node doInsert(Node root, int value) {

        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = doInsert(root.left, value);
        } else if (value > root.value) {
            root.right = doInsert(root.right, value);
        }
        return root;
    }

}
