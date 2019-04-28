package by.bsu.seredinski.sort;

import by.bsu.seredinski.entity.Thing;

import java.util.List;

public class QuickSort {

    public static void sorting(List<Thing> things, int start, int end) {
        if (start >= end) {
            return;
        }
        int curr = start - (start - end) / 2;
        curr = getCurr(things, start, end, curr);
        sorting(things, start, curr);
        sorting(things, curr + 1, end);
    }

    private static int getCurr(List<Thing> things, int i, int j, int curr) {
        while (i < j) {
            while ((things.get(i).getWeight() <= things.get(curr).getWeight()) && i < curr) {
                i++;
            }
            while ((things.get(curr).getWeight() <= things.get(j).getWeight()) && j > curr) {
                j--;
            }
            if (i < j) {
                Thing a = new Thing(things.get(i));
                things.set(i, new Thing(things.get(j)));
                things.set(j, a);
                if (i == curr)
                    curr = j;
                else {
                    if (j == curr)
                        curr = i;
                }
            }
        }
        return curr;
    }
}
