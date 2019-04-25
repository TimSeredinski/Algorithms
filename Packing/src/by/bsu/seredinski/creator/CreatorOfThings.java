package by.bsu.seredinski.creator;

import by.bsu.seredinski.entity.Thing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatorOfThings {

    public List<Thing> fillArrayOfThings(int n) {
        List<Thing> things = new ArrayList<>();
        for (; n > 0; n--) {
            double weight = new Random().nextInt(11) + 1;
            things.add(new Thing(weight / 10));
        }
        return things;
    }
}
