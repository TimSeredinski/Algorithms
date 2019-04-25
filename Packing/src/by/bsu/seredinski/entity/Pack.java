package by.bsu.seredinski.entity;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    private double capacity;
    private List<Thing> things;

    public Pack() {
        this.capacity = 1.0;
        this.things = new ArrayList<>();
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
}
