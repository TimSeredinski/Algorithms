package by.bsu.seredinski.algorithm;

import by.bsu.seredinski.entity.Pack;
import by.bsu.seredinski.entity.Thing;

import java.util.Deque;

public class FirstSuitable {
    private int numberOfPackages;

    public void wrapUp(Deque<Pack> packages, Thing thing) {
        boolean shouldCreateNewPack = true;
        for (Pack pack : packages) {
            if (pack.getCapacity() >= thing.getWeight()) {
                pack.setCapacity(pack.getCapacity() - thing.getWeight());
                pack.getThings().add(thing);
                System.out.println("Thing num-" + thing.getNumber() + " was added in package number is " + pack.getNumber());
                shouldCreateNewPack = false;
                break;
            }
        }
        if (shouldCreateNewPack) {
            numberOfPackages++;
            packages.addLast(new Pack(numberOfPackages));
            Pack pack = packages.getLast();
            pack.setCapacity(pack.getCapacity() - thing.getWeight());
            pack.getThings().add(thing);
            System.out.println("Thing num-" + thing.getNumber() + " was added in package number is " + pack.getNumber());
        }
    }
}
