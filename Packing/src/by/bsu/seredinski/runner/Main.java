package by.bsu.seredinski.runner;

import by.bsu.seredinski.algorithm.SuitableWithSort;
import by.bsu.seredinski.creator.CreatorOfThings;
import by.bsu.seredinski.entity.Pack;
import by.bsu.seredinski.entity.Thing;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CreatorOfThings creator = new CreatorOfThings();
        List<Thing> things = new ArrayList<>();
        things.addAll(creator.fillArrayOfThings(100));
        Deque<Pack> packages = new LinkedList<>();
        SuitableWithSort algorithm = new SuitableWithSort();
        for (Thing thing : things) {
            algorithm.wrapUp(packages, thing);
        }
        printPackages(packages);
    }

    private static void printPackages(Queue<Pack> packages) {
        int i = 0;
        for (Pack pack : packages) {
            System.out.print(i++ + ". ");
            System.out.println(pack.toString());
        }
    }
}
