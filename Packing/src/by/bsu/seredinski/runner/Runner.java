package by.bsu.seredinski.runner;

import by.bsu.seredinski.algorithm.FirstSuitable;
import by.bsu.seredinski.creator.CreatorOfThings;
import by.bsu.seredinski.entity.Pack;
import by.bsu.seredinski.entity.Thing;
import by.bsu.seredinski.sort.QuickSort;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        CreatorOfThings creator = new CreatorOfThings();
        List<Thing> things = new ArrayList<>();
        things.addAll(creator.fillArrayOfThings(100));
        runner.runHybridAlgWithSorting(things);

        things = new ArrayList<>();
        runner.runAlgWithoutSorting(things);
    }

    private void printPackages(Queue<Pack> packages) {
        for (Pack pack : packages) {
            System.out.println(pack.toString());
        }
    }

    private void runHybridAlgWithSorting(List<Thing> things) {
        Runner runner = new Runner();
        QuickSort.sorting(things, 0, things.size() - 1);
        Collections.reverse(things);
        System.out.println(Arrays.toString(things.toArray()));
        Deque<Pack> packages = new LinkedList<>();
        FirstSuitable algorithm = new FirstSuitable();
        for (Thing thing : things) {
            algorithm.wrapUp(packages, thing);
        }
        runner.printPackages(packages);
    }

    private void runAlgWithoutSorting(List<Thing> things) {
        Runner runner = new Runner();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of things you want to add: ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.println("Enter 'a' end 'b' where (a/b) = weight of thing num-" + i + ": ");
            double a = scanner.nextInt();
            double b = scanner.nextInt();
            things.add(new Thing(a / b, i));
        }
        Deque<Pack> packages = new LinkedList<>();
        FirstSuitable algorithm = new FirstSuitable();
        for (Thing thing : things) {
            algorithm.wrapUp(packages, thing);
        }
        runner.printPackages(packages);
    }
}
