package by.bsu.seredinski.entity;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    private double capacity;
    private List<Thing> things;
    private int number;

    public Pack(int number) {
        this.capacity = 1.0;
        this.things = new ArrayList<>();
        this.number = number;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Thing> getThings() {
        return things;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Pack num-" + number + " (" +
                "capacity=" + capacity +
                ", things=" + things +
                " )";
    }
}
