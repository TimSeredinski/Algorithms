package by.bsu.seredinski;

public class Node {

    int element;
    Node next;

    public Node(int value) {
        element = value;
        next = null;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
