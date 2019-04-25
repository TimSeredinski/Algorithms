package by.bsu.seredinski.entity;

public class Thing {
    private double weight;

    public Thing() {
    }

    public Thing(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "weight=" + weight +
                '}';
    }
}
