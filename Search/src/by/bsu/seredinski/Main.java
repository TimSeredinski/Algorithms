package by.bsu.seredinski;

public class Main {

    public static void main(String[] args) {

        for (int i = 2; i < 20; i++) {
            int[] array = new int[i];
            Array.createArray(array, i);
            Sorting.insertionSort(array, 0, array.length - 1);
            int randomNumberToFind = 1 + (int) (Math.random() * 20);

            long startBinary = System.nanoTime();
            Search.binarySearch(array, randomNumberToFind);
            long endBinary = System.nanoTime() - startBinary;

            long startInterpolation = System.nanoTime();
            Search.interpolationSearch(array, randomNumberToFind);
            long endInterpolation = System.nanoTime() - startInterpolation;

            if (endBinary < endInterpolation) {
                System.out.println("Бинарный - " + endBinary + ", интерполяционный - " + endInterpolation);
                System.out.println("Бинарный поиск быстрее интерполяционного на  массиве размером - " + i);
                break;
            }
        }
    }
}
