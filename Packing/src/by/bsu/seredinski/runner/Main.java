package by.bsu.seredinski.runner;

import by.bsu.seredinski.creator.CreatorOfThings;
import by.bsu.seredinski.entity.Thing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CreatorOfThings creator = new CreatorOfThings();
        List<Thing> things = new ArrayList<>();
        things.addAll(creator.fillArrayOfThings(100));
        for (Thing thing : things) {
            System.out.println(thing.getWeight());
        }
//        for (Thing thing : things) {
//        }
        }
}
