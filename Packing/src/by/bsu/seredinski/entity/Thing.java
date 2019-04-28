package by.bsu.seredinski.entity;

public class Thing {
    private int number;
    private double weight;

    public Thing() {

    }

    public Thing(double weight, int number) {
        this.weight = weight;
        this.number = number;
    }

    public Thing(Thing thing) {
        this.weight = thing.getWeight();
        this.number = thing.getNumber();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Thing num-" + number + " (" +
                "weight= " + weight +
                ")";
    }
}
