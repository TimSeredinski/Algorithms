package by.bsu.seredinski;

public class NodeForQuadtaric {

    int element;
    int key;

    public NodeForQuadtaric() {
        element = 0;
        key = 0;
    }

    public NodeForQuadtaric(int element, int key) {
        this.element = element;
        this.key = key;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
