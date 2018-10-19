package by.bsu.seredinski;

public class ChainOfCollisions {

    Node first;
    Node last;
    int length = 0;

    public void insertion(int value) {
        length++;
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            Node node = new Node(value);
            last.setNext(node);
            last = node;
        }
    }

    public Node search(int value) {
        return search(first, value);
    }

    private Node search(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.getElement() == value) {
            return node;
        } else return search(node.getNext(), value);
    }

    public int getLength() {
        return length;
    }
}
