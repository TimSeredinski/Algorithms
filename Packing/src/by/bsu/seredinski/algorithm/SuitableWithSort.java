package by.bsu.seredinski.algorithm;

import by.bsu.seredinski.entity.Pack;
import by.bsu.seredinski.entity.Thing;

import java.util.Deque;

public class SuitableWithSort {
    private static int numberOfPackages;
    private static int indexOfThing;

    public void wrapUp(Deque<Pack> packages, Thing thing) {
        indexOfThing++;
        boolean shouldCreateNewPack = true;
        for (Pack pack : packages) {
            if (pack.getCapacity() >= thing.getWeight()) {
                pack.setCapacity(pack.getCapacity() - thing.getWeight());
                pack.getThings().add(thing);
                System.out.println("Thing number is " + indexOfThing + " was added in package number is " + numberOfPackages);
                shouldCreateNewPack = false;
                break;
            }
        }
        if (shouldCreateNewPack) {
            numberOfPackages++;
            packages.addLast(new Pack());
            Pack pack = packages.getLast();
            pack.setCapacity(pack.getCapacity() - thing.getWeight());
            pack.getThings().add(thing);
            System.out.println("Thing number is " + indexOfThing + " was added in package number is " + numberOfPackages);
        }
    }
}
