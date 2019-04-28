package by.bsu.seredinski.creator;

import by.bsu.seredinski.entity.Thing;

import java.util.ArrayList;
import java.util.List;

public class CreatorOfThings {

    public List<Thing> fillArrayOfThings(int n) {
        List<Thing> things = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            things.add(new Thing(Math.random(), i));
        }
        return things;
    }
}
